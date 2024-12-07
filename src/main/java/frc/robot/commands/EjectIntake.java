// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.StateMachine;
import frc.robot.subsystems.StateMachine.RobotState;

public class EjectIntake extends Command {
  /** Creates a new EjectGP. */

  Intake globalIntake;
  StateMachine globalStateMachine;

  public EjectIntake(StateMachine passedStateMachine, Intake subIntake) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.globalIntake = subIntake;
    globalStateMachine = passedStateMachine;
    addRequirements(globalStateMachine);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    globalStateMachine.setState(RobotState.EJECT_INTAKE);
    globalIntake.setIntakeVelocity(Constants.constIntake.INTAKE_EJECT_VELOCITY);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
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