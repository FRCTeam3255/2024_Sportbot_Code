// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.constLED;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.LED;

public class FullHopper extends Command {
  /** Creates a new FullHopper. */
  Hopper subHopper;
  LED subLED;

  public FullHopper(Hopper subHopper, LED fullLED) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.subHopper = subHopper;
    subLED = fullLED;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    subLED.setLEDs(constLED.LED_FULL_HOPPER);
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
    return true;
  }
}
