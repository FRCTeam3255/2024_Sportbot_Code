// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.frcteam3255.joystick.SN_XboxController;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.Drive;
import frc.robot.commands.EjectIntake;
import frc.robot.commands.IntakeGround;
import frc.robot.commands.PrepShooter;
import frc.robot.commands.Shoot;
import frc.robot.commands.intakeHopper;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Stager;

public class RobotContainer {
  private final SN_XboxController m_driverController = new SN_XboxController(RobotMap.mapControllers.DRIVER_USB);
  private final Drivetrain subDrivetrain = new Drivetrain();
  private final Intake subIntake = new Intake();
  private final Hopper subHopper = new Hopper();
  private final Shooter subShooter = new Shooter();
  private final Stager subStager = new Stager();
  private final Drive com_Drive = new Drive(subDrivetrain, m_driverController.axis_RightX,
      m_driverController.axis_LeftY, m_driverController.btn_LeftBumper);
  private final IntakeGround com_IntakeGround = new IntakeGround(subIntake, subStager);
  private final PrepShooter com_PrepShooter = new PrepShooter(subShooter);
  private final Shoot com_Shoot = new Shoot(subStager, subShooter);
  private final intakeHopper com_IntakeHopper = new intakeHopper(subHopper, subStager);
  private final EjectIntake com_EjectIntake = new EjectIntake(subIntake, subHopper);

  public RobotContainer() {
    subDrivetrain.setDefaultCommand(com_Drive);
    m_driverController.setLeftDeadband(Constants.constDrivetrain.CONTROLLER_DEADZONE);
    m_driverController.setRightDeadband(Constants.constDrivetrain.CONTROLLER_DEADZONE);
    configureBindings();
  }
 
  private void configureBindings() {
    m_driverController.btn_LeftTrigger.whileTrue(com_IntakeGround);
    m_driverController.btn_A.whileTrue(com_PrepShooter);
    m_driverController.btn_B.whileTrue(com_IntakeHopper);
    m_driverController.btn_LeftBumper.whileTrue(com_EjectIntake);
    m_driverController.btn_RightTrigger.onTrue(com_Shoot);

  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}