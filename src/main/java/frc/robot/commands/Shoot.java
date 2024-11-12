// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Stager;
import frc.robot.Constants;
import frc.robot.subsystems.Shooter;

public class Shoot extends Command {
  /** Creates a new Shoot. */
  Stager globalStager;
  Shooter globalShooter;

  public Shoot(Stager passedStager, Shooter passedShooter) {
    // Use addRequirements() here to declare subsystem dependencies.
    globalStager = passedStager;
    globalShooter = passedShooter;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // The speed need to change to a real number.
    if ((globalShooter.getPropelMotorVelocity() >= Constants.constShooter.PROPEL_MOTOR_VELOCITY) && (globalShooter.getSpiralMotorVelocity() >= Constants.constShooter.SPIRAL_MOTOR_VELOCITY)) {
      globalStager.setStagerMotorVelocity(Constants.constStager.STAGER_MOTOR_VELOCITY);
    } else {
      globalStager.setStagerMotorVelocity(0);
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    globalShooter.setPropelMotorVelocity(0);
    globalShooter.setSpiralMotorVelocity(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
