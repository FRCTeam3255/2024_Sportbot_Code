// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.Constants.constLED;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.LED;

public class EjectGP extends Command {
  /** Creates a new EjectGP. */
  LED globalLED;
  Intake globalIntake;
  Hopper globalHopper;

  public EjectGP(Intake subIntake, Hopper subHopper, LED ejectLED) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.globalHopper = subHopper;
    this.globalIntake = subIntake;
    globalLED = ejectLED;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    globalIntake.setIntakeVelocity(-0.5);
    globalLED.setLEDs(constLED.LED_EJECTGP);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    globalHopper.setOrientationMotorNuetralOutput();
    globalIntake.setIntakeNuetralOutput();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
