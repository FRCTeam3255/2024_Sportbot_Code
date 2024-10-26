// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class Drive extends Command {
  /** Creates a new Drive. */

  Drivetrain globalDrivetrain;
  DoubleSupplier forwardSpeed;
  DoubleSupplier rotationSpeed;

  public Drive(Drivetrain passedDrivetrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    globalDrivetrain = passedDrivetrain;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    globalDrivetrain.setLeftSpeed(forwardSpeed.getAsDouble());
    globalDrivetrain.setRightSpeed(forwardSpeed.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
