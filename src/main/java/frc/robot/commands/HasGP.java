// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Stager;
import frc.robot.Constants.constLED;
import frc.robot.subsystems.LED;

public class HasGP extends Command {
  /** Creates a new StageGP. */
  Stager globalStager;
  LED globalLED;
  Shooter globalShooter;

  public HasGP(Stager passedStager, Shooter passedShooter, LED stagerLED) {
    // Use addRequirements() here to declare subsystem dependencies.
    globalStager = passedStager;
    globalShooter = passedShooter;
    globalLED = stagerLED;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    globalLED.setLEDs(constLED.LED_HASGP);
    globalShooter.setShooterNuetralOutput();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
