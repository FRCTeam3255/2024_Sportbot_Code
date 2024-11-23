// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Shooter;

public class PrepShooter extends Command {
  /** Creates a new PrepShooter. */
  Shooter globalShooter;

  public PrepShooter(Shooter passedShooter) {
    // Use addRequirements() here to declare subsystem dependencies.
    globalShooter = passedShooter;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    globalShooter.setPropelMotorVelocity(Constants.constShooter.PROPEL_MOTOR_VELOCITY);
    globalShooter.setSpiralMotorVelocity(Constants.constShooter.SPIRAL_MOTOR_VELOCITY);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    globalShooter.setShooterNuetralOutput();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
