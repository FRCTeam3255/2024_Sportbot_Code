// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Stager;
import frc.robot.Constants.constLED;
import frc.robot.subsystems.LED;
import frc.robot.Constants;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.StateMachine.RobotState;
import frc.robot.subsystems.StateMachine;

public class Shoot extends Command {
  /** Creates a new Shoot. */
  StateMachine globalStateMachine;
  Stager globalStager;
  Shooter globalShooter;
  LED globalLED;

  public Shoot(StateMachine passedStateMachine, Stager passedStager, Shooter passedShooter, LED shootLED) {
    // Use addRequirements() here to declare subsystem dependencies.
    globalStateMachine = passedStateMachine;
    addRequirements(globalStateMachine);
    globalStager = passedStager;
    globalShooter = passedShooter;
    globalLED = shootLED;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    globalStateMachine.setState(RobotState.SHOOT);
    globalShooter.setPropelMotorVelocity(Constants.constShooter.PROPEL_MOTOR_VELOCITY);
    globalShooter.setSpiralMotorVelocity(Constants.constShooter.SPIRAL_MOTOR_VELOCITY);
    if ((globalShooter.getPropelMotorVelocity() >= Constants.constShooter.PROPEL_MOTOR_VELOCITY)
        && (globalShooter.getSpiralMotorVelocity() >= Constants.constShooter.SPIRAL_MOTOR_VELOCITY)) {
      globalStager.setStagerMotorVelocity(Constants.constStager.STAGER_MOTOR_VELOCITY);
      globalLED.setLEDs(constLED.LED_SHOOTING);
    } else {
      globalStager.setStagerMotorVelocityNuetralOutput();
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    globalStager.setStagerMotorVelocityNuetralOutput();
    globalShooter.setShooterNuetralOutput();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
