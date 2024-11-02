// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.frcteam3255.joystick.SN_XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.Drive;
import frc.robot.subsystems.Drivetrain;
import frc.robot.commands.IntakeGround;
import frc.robot.commands.PrepShooter;
import frc.robot.commands.StageGP;
import frc.robot.commands.intakeHopper;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Stager;

public class RobotContainer {
  private final SN_XboxController m_driverController = new SN_XboxController(RobotMap.mapControllers.DRIVER_USB);

  Drivetrain subDrivetrain = new Drivetrain();

  public RobotContainer() {
    subDrivetrain.setDefaultCommand(new Drive(subDrivetrain, m_driverController.axis_LeftY, m_driverController.axis_RightX));
    final Intake subIntake = new Intake();
    final Hopper subHopper = new Hopper();
    final Shooter subShooter = new Shooter();
    final Stager subStager = new Stager();
    final IntakeGround com_IntakeGround = new IntakeGround(subIntake, subHopper);
    final PrepShooter com_PrepShooter = new PrepShooter(subShooter);
    final StageGP com_StageGP = new StageGP(subStager);
    configureBindings(com_IntakeGround, subHopper, com_PrepShooter, com_StageGP);
  }

  private void configureBindings(IntakeGround com_IntakeGround, Hopper subHopper, PrepShooter com_PrepShooter, StageGP com_StageGP) {
    m_driverController.btn_B.whileTrue(com_IntakeGround);
    m_driverController.btn_LeftBumper.whileTrue(new intakeHopper(subHopper));
    m_driverController.btn_X.onTrue(com_PrepShooter);
    m_driverController.btn_A.whileTrue(com_StageGP);
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
