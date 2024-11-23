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

public class Shoot extends Command {
  /** Creates a new Shoot. */
  Stager globalStager;
  Shooter globalShooter;
  LED globalLED;

  public Shoot(Stager passedStager, Shooter passedShooter, LED shootLED) {
    // Use addRequirements() here to declare subsystem dependencies.
    globalStager = passedStager;
    globalShooter = passedShooter;
    globalLED = shootLED;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if ((globalShooter.getPropelMotorVelocity() >= 0.6) && (globalShooter.getSpiralMotorVelocity() >= 0.8)) {
      globalStager.setStagerMotorVelocity(0.3);
      globalLED.setLEDs(constLED.LED_SHOOTING);
      if ((globalShooter.getPropelMotorVelocity() >= Constants.constShooter.PROPEL_MOTOR_VELOCITY)
          && (globalShooter.getSpiralMotorVelocity() >= Constants.constShooter.SPIRAL_MOTOR_VELOCITY)) {
        globalStager.setStagerMotorVelocity(Constants.constStager.STAGER_MOTOR_VELOCITY);
        globalStager.setTopStagerMotorVelocity(Constants.constStager.TOP_STAGER_MOTOR_VELOCITY);
      } else {
        globalStager.setStagerMotorVelocityNuetralOutput();
      }
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
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
