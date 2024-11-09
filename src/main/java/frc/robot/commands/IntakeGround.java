// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;

public class IntakeGround extends Command {
  /** Creates a new IntakeGround. */
  Intake globalIntake;
  Hopper globalHopper;

  public IntakeGround(Intake passedIntake, Hopper passedHopper) {
    // Use addRequirements() here to declare subsystem dependencies.
    globalIntake = passedIntake;
    globalHopper = passedHopper;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    globalIntake.setIntakeVelocity(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // if hopper is full
    if (globalHopper.isHopperFull()) {
      globalIntake.setIntakeVelocity(0);
    } else {
      globalIntake.setIntakeVelocity(0.5);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    globalIntake.setIntakeNuetralOutput();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
