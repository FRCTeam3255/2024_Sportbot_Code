// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.frcteam3255.joystick.SN_XboxController;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public class RobotContainer {
  private final SN_XboxController m_driverController = new SN_XboxController(0);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    m_driverController.btn_A.whileTrue(new SpinMotor(MyMotorMoverName, m_driverController.axis_RightTrigger, m_driverController.axis_LeftTrigger));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
