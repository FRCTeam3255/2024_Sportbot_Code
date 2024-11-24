// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.*;

public class StateMachine extends SubsystemBase {
  /** Creates a new StateMachine. */
  public static RobotState currentState;
  Hopper globalHopper;
  Intake globalIntake;
  Shooter globalShooter;
  Stager globalStager;

  public StateMachine(Hopper passedHopper, Intake passedIntake, Shooter passedShooter, Stager passedStager) {
    globalHopper = passedHopper;
    globalIntake = passedIntake;
    globalShooter = passedShooter;
    globalStager = passedStager;
    currentState = RobotState.NONE;
  }

  public enum RobotState {
    EJECT_INTAKE,
    EJECT_SHOOTER,
    HAS_GP,
    INTAKE_GROUND,
    INTAKE_HOPPER,
    NONE,
    PREP_SHOOTER,
    SHOOT,
  }

  public void setState(RobotState state) {
    currentState = state;
  }

  public RobotState getState() {
    return currentState;
  }

  public Command tryState(RobotState desiredState) {
    switch (desiredState) { // check what our desired state is
      case EJECT_INTAKE: // if desired state is eject intake
        switch (currentState) { // check what our current state is
          case INTAKE_GROUND: // what are we allowed to come from
            return new EjectIntake(globalIntake);
        }
        break;
      case EJECT_SHOOTER:
        switch (currentState) {
          case HAS_GP:
          case PREP_SHOOTER:
            return new EjectShooter(globalStager, globalShooter);
        }
        break;
      case HAS_GP:
        switch (currentState) {
          case INTAKE_GROUND:
          case INTAKE_HOPPER:
          case PREP_SHOOTER:
          case SHOOT:
            return new HasGP(globalStager);
        }
        break;
      case INTAKE_GROUND: // if desired state is intake ground
        switch (currentState) { // check what our current state is
          case NONE: // what are we allowed to come from
            return new IntakeGround(this, globalIntake, globalStager);
        }
        break;
      case INTAKE_HOPPER:
        switch (currentState) {
          case NONE: // is the current state NONE
          case INTAKE_GROUND: // or is the current state INTAKE_GROUND
            return new intakeHopper(globalHopper, globalStager);
        }
        break;
      case NONE:
        switch (currentState) {
          case EJECT_INTAKE:
          case EJECT_SHOOTER:
          case SHOOT:
            return new none(globalHopper, globalIntake, globalShooter, globalStager);
        }
        break;
      case PREP_SHOOTER:
        switch (currentState) {
          case HAS_GP:
            return new PrepShooter(globalShooter);
        }
        break;
      case SHOOT:
        switch (currentState) {
          case PREP_SHOOTER:
            return new Shoot(globalStager, globalShooter);
        }
        break;
      // default:
      // return new None(globalHopper, globalIntake, globalShooter, globalStager);
    }
    return Commands.print("Invalid state provided: Blame Eli, he provided it >:(");

  }

  @Override
  public void periodic() {

    // This method will be called once per scheduler run
    SmartDashboard.putString("Current State", currentState.toString());
  }
}
