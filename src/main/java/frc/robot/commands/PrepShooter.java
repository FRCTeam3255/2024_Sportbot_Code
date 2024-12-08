// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Constants.constLED;
import frc.robot.subsystems.LED;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.StateMachine;
import frc.robot.subsystems.StateMachine.RobotState;

public class PrepShooter extends Command {
  /** Creates a new PrepShooter. */
  Shooter globalShooter;
  StateMachine globalStateMachine;
  LED globalLED;

  public PrepShooter(StateMachine passedStateMachine, Shooter passedShooter, LED prepLED) {
    // Use addRequirements() here to declare subsystem dependencies.
    globalShooter = passedShooter;
    globalLED = prepLED;
    globalStateMachine = passedStateMachine;
    addRequirements(globalStateMachine);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    globalStateMachine.setState(RobotState.PREP_SHOOTER);
    globalShooter.setPropelMotorVelocity(Constants.constShooter.PROPEL_MOTOR_VELOCITY);
    globalShooter.setSpiralMotorVelocity(Constants.constShooter.SPIRAL_MOTOR_VELOCITY);
    globalLED.setLEDs(constLED.LED_PREP_SHOOTING);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    globalShooter.setPropelMotorVelocity(Constants.constShooter.PROPEL_MOTOR_VELOCITY);
    globalShooter.setSpiralMotorVelocity(Constants.constShooter.SPIRAL_MOTOR_VELOCITY);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
