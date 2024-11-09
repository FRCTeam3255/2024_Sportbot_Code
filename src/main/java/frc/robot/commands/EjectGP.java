// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;

public class EjectGP extends Command {
  /** Creates a new EjectGP. */

  Intake globalIntake;
  Hopper globalHopper;

  public EjectGP(Intake subIntake, Hopper subHopper) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.globalHopper = subHopper;
    this.globalIntake = subIntake;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    globalIntake.setIntakeVelocity(-0.5);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    globalHopper.setHopperMotorNuetralOutput();
    globalIntake.setIntakeNuetralOutput();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}