// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Stager;
import frc.robot.Constants;

public class EjectShooter extends Command {
  /** Creates a new EjectShooter. */
  Stager globalStager;
  Shooter globalShooter;

  public EjectShooter(Stager passedStager, Shooter passedShooter) {
    // Use addRequirements() here to declare subsystem dependencies.
    globalStager = passedStager;
    globalShooter = passedShooter;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    globalShooter.setPropelMotorVelocity(Constants.constShooter.PROPEL_MOTOR_VELOCITY_EJECT);
    globalShooter.setSpiralMotorVelocity(Constants.constShooter.SPIRAL_MOTOR_VELOCITY_EJECT);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if ((globalShooter.getPropelMotorVelocity() >= Constants.constShooter.PROPEL_MOTOR_VELOCITY_EJECT_REQUIREMENT)
        && globalShooter.getSpiralMotorVelocity() >= Constants.constShooter.SPIRAL_MOTOR_VELOCITY_EJECT_REQUIREMENT) {
      globalStager.setStagerMotorVelocity(Constants.constStager.STAGER_MOTOR_VELOCITY);
      globalStager.setTopStagerMotorVelocity(Constants.constStager.TOP_STAGER_MOTOR_VELOCITY);
    } else {
      globalStager.setStagerMotorVelocityNuetralOutput();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    globalStager.setStagerMotorVelocityNuetralOutput();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
