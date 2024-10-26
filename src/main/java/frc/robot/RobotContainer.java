// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.frcteam3255.joystick.SN_XboxController;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.intakeHopper;
import frc.robot.commands.states.IntakeGround;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;

public class RobotContainer {
  private final SN_XboxController m_driverController = new SN_XboxController(1);
  Intake subIntake = new Intake();
  Hopper subHopper = new Hopper();
  IntakeGround com_IntakeGround = new IntakeGround(subIntake, subHopper);

  public RobotContainer() {
    configureBindings();

  }

  private void configureBindings() {
    m_driverController.btn_B.whileTrue(com_IntakeGround);
    m_driverController.btn_LeftBumper.whileTrue(new intakeHopper(subHopper));

  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
