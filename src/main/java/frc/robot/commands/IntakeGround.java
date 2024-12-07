// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Stager;
import frc.robot.subsystems.StateMachine;
import frc.robot.subsystems.StateMachine.RobotState;
import frc.robot.Constants;
import frc.robot.Constants.constLED;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.LED;

public class IntakeGround extends Command {
  /** Creates a new IntakeGround. */
  Intake globalIntake;
  Stager globalStager;
  StateMachine globalStateMachine;
  LED globalLED;

  public IntakeGround(StateMachine passedStateMachine, Intake passedIntake, Stager passedStager, LED groundIntakeLED) {
    // Use addRequirements() here to declare subsystem dependencies.
    globalStateMachine = passedStateMachine;
    addRequirements(globalStateMachine);
    globalIntake = passedIntake;
    globalStager = passedStager;
    globalLED = groundIntakeLED;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    globalStateMachine.setState(RobotState.INTAKE_GROUND);
    globalIntake.setIntakeNuetralOutput();
    globalLED.setLEDs(constLED.LED_INTAKE_GROUND);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // if Stager is full

    if (globalStager.getHasGP()) {
      globalIntake.setIntakeNuetralOutput();
    } else {
      globalIntake.setIntakeVelocity(Constants.constIntake.INTAKE_VELOCITY);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    globalIntake.setIntakeNuetralOutput();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
