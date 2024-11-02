// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.frcteam3255.joystick.SN_XboxController;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.Drive;
import frc.robot.subsystems.Drivetrain;
  
Drivetrain subDrivetrain = new Drivetrain();
import frc.robot.commands.IntakeGround;
import frc.robot.commands.PrepShooter;
import frc.robot.commands.StageGP;
import frc.robot.commands.intakeHopper;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Stager;

  public RobotContainer() {
    subDrivetrain.setDefaultCommand(new Drive(subDrivetrain, m_driverController.axis_LeftY, m_driverController.axis_RightX));
    private final SN_XboxController m_driverController = new SN_XboxController(RobotMap.mapControllers.DRIVER_USB);
    private final Intake subIntake = new Intake();
    private final Hopper subHopper = new Hopper();
    private final Shooter subShooter = new Shooter();
    private final Stager subStager = new Stager();
    private final IntakeGround com_IntakeGround = new IntakeGround(subIntake, subHopper);
    private final PrepShooter com_PrepShooter = new PrepShooter(subShooter);
    private final StageGP com_StageGP = new StageGP(subStager);
    configureBindings();
  }

  private void configureBindings() {
    m_driverController.btn_B.whileTrue(com_IntakeGround);
    m_driverController.btn_LeftBumper.whileTrue(new intakeHopper(subHopper));
    m_driverController.btn_X.onTrue(com_PrepShooter);
    m_driverController.btn_A.whileTrue(com_StageGP);
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
