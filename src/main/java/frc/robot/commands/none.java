// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Stager;

public class none extends Command {
  Hopper subHopper;
  Intake subIntake;
  Shooter subShooter;
  Stager subStager;
  /** Creates a new none. */
  public none(Hopper passedHopper, Intake passedIntake, Shooter passedShooter, Stager passedStager) {
    // Use addRequirements() here to declare subsystem dependencies.
    subHopper = passedHopper;
    subIntake = passedIntake;
    subShooter = passedShooter;
    subStager = passedStager;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    subHopper.setHopperMotorSpeed(0);
    subIntake.setTopMotorVelocity(0);
    subStager.setConveyorMotorVelocity(0);
    subShooter.setSpiralMotorVelocity(0);
    subShooter.setPropelMotorVelocity(0);
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