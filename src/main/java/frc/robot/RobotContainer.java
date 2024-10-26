// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.frcteam3255.joystick.SN_XboxController;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.intakeHopper;
import frc.robot.subsystems.Hopper;

public class RobotContainer {
  private final SN_XboxController m_driverController = new SN_XboxController(0);
  private final Hopper subHopper = new Hopper();

  public RobotContainer() {
    configureBindings();

  }

  private void configureBindings() {
    m_driverController.btn_LeftBumper.whileTrue(new intakeHopper(subHopper));

  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
