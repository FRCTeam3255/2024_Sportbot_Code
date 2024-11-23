// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Constants.constLED;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.LED;
import frc.robot.subsystems.Stager;

public class intakeHopper extends Command {

  Hopper subHopper;
  Stager subStager;
  LED subLED;

  /** Creates a new intakeHopper. */
  public intakeHopper(Hopper subHopper, Stager subStager, LED intakeHopperLED) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.subHopper = subHopper;
    this.subStager = subStager;
    subLED = intakeHopperLED;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    subHopper.setOrientationMotorSpeed(.5);
    subLED.setLEDs(constLED.LED_INTAKE_HOPPER);
    subHopper.setOrientationMotorSpeed(Constants.constHopper.HOPPER_ORIENTATION_SPEED);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (!subStager.getHasGP()) {
      subHopper.setOrientationMotorSpeed(Constants.constHopper.HOPPER_ORIENTATION_SPEED);
    } else {
      subHopper.setOrientationMotorNuetralOutput();
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    subHopper.setOrientationMotorNuetralOutput();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
