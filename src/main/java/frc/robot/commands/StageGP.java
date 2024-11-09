// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Stager;

public class StageGP extends Command {
  /** Creates a new StageGP. */
  Stager globalStager;

  public StageGP(Stager passedStager) {
    // Use addRequirements() here to declare subsystem dependencies.
    globalStager = passedStager;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    globalStager.setStagerMotorVelocity(0.3);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (globalStager.getHasGP()) {
      globalStager.setStagerMotorVelocity(0);
    } else {
      globalStager.setStagerMotorVelocity(0.3);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    globalStager.setStagerMotorVelocity(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
