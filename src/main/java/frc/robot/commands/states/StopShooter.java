// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.states;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.StateMachine;
import frc.robot.subsystems.StateMachine.RobotState;

public class StopShooter extends Command {
  /** Creates a new StopShooter. */
   Shooter globalShooter;
  StateMachine globalStateMachine;
  public StopShooter(StateMachine passedStateMachine, Shooter passedShooter) {
    // Use addRequirements() here to declare subsystem dependencies.
    globalStateMachine = passedStateMachine;
    addRequirements(globalStateMachine);
    globalShooter = passedShooter;

  
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    globalStateMachine.setState(RobotState.STOP_SHOOTER);
    globalShooter.setShooterNuetralOutput();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
