// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;
import frc.robot.subsystems.LED;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.constLED;
import frc.robot.subsystems.Drivetrain;

public class Drive extends Command {
  /** Creates a new Drive. */
  LED globalLED;
  Drivetrain globalDrivetrain;
  DoubleSupplier globalForwardSpeed;
  DoubleSupplier globalRotationSpeed;
  Trigger globalSlowMode;

  public Drive(Drivetrain passedDrivetrain, DoubleSupplier passedForwardSpeed, DoubleSupplier passedRotationSpeed,
      Trigger passedSlowMode, LED driveLED) {
    // Use addRequirements() here to declare subsystem dependencies.
    globalDrivetrain = passedDrivetrain;
    globalForwardSpeed = passedForwardSpeed;
    globalRotationSpeed = passedRotationSpeed;
    globalSlowMode = passedSlowMode;
    globalLED = driveLED;
    addRequirements(globalDrivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    globalDrivetrain.setDrivetrainSpeed(globalForwardSpeed.getAsDouble(), globalRotationSpeed.getAsDouble(),
        globalSlowMode.getAsBoolean());
    globalLED.setLEDs(constLED.LED_DRIVE);
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
