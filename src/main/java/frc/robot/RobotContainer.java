// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.frcteam3255.joystick.SN_XboxController;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.Drive;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Stager;
import frc.robot.subsystems.StateMachine;
import frc.robot.subsystems.StateMachine.RobotState;

public class RobotContainer {
  private final SN_XboxController m_driverController = new SN_XboxController(RobotMap.mapControllers.DRIVER_USB);
  private final Drivetrain subDrivetrain = new Drivetrain();
  private final Intake subIntake = new Intake();
  private final Hopper subHopper = new Hopper();
  private final Shooter subShooter = new Shooter();
  private final Stager subStager = new Stager();
  private final StateMachine subStateMachine = new StateMachine(subHopper, subIntake, subShooter, subStager);

  private final Drive com_Drive = new Drive(subDrivetrain, m_driverController.axis_RightX,
      m_driverController.axis_LeftY, m_driverController.btn_LeftBumper);

  private final Trigger hasGamePieceTrigger = new Trigger(subStager::getHasGP);
  private final Trigger isGPDetectedTrigger = new Trigger(subHopper::getGamePieceHopper);

  // Drive
  public RobotContainer() {
    subDrivetrain.setDefaultCommand(com_Drive);
    m_driverController.setLeftDeadband(Constants.constDrivetrain.CONTROLLER_DEADZONE);
    m_driverController.setRightDeadband(Constants.constDrivetrain.CONTROLLER_DEADZONE);
    configureBindings();
  }

  private void configureBindings() {
    // Intake
    m_driverController.btn_LeftTrigger
        .whileTrue(Commands.deferredProxy(
            () -> subStateMachine.tryState(RobotState.INTAKE_GROUND)))
        .onFalse(Commands.deferredProxy(
            () -> subStateMachine.tryState(RobotState.NONE))
            .unless(isGPDetectedTrigger));

    // PrepShooter
    m_driverController.btn_A
        .whileTrue(Commands.deferredProxy(
            () -> subStateMachine.tryState(RobotState.PREP_SHOOTER)));

    // IntakeHopper
    isGPDetectedTrigger
        .onTrue(Commands.deferredProxy(
            () -> subStateMachine.tryState(RobotState.INTAKE_HOPPER)));

    // EjectShooter
    m_driverController.btn_RightBumper
        .whileTrue(Commands.deferredProxy(
            () -> subStateMachine.tryState(RobotState.EJECT_SHOOTER)))
        .onFalse(Commands.deferredProxy(
            () -> subStateMachine.tryState(RobotState.NONE)));

    // EjectIntake
    m_driverController.btn_LeftBumper
        .whileTrue(Commands.deferredProxy(
            () -> subStateMachine.tryState(RobotState.EJECT_INTAKE)))
        .onFalse(Commands.deferredProxy(
            () -> subStateMachine.tryState(RobotState.NONE)));

    // Shoot
    m_driverController.btn_RightTrigger
        .onTrue(Commands.deferredProxy(
            () -> subStateMachine.tryState(RobotState.SHOOT)))
        .onFalse(Commands.deferredProxy(
            () -> subStateMachine.tryState(RobotState.NONE)));

    // prepShooter -> hasGP
    if (subStateMachine.getState() == RobotState.PREP_SHOOTER) {
      m_driverController.btn_B
          .onTrue(Commands.deferredProxy(
              () -> subStateMachine.tryState(RobotState.HAS_GP)));
    }

    // hasGP
    if (subStateMachine.getState() == RobotState.SHOOT || subStateMachine.getState() == RobotState.NONE
        || subStateMachine.getState() == RobotState.INTAKE_HOPPER) {
      hasGamePieceTrigger
          .onTrue(Commands.deferredProxy(
              () -> subStateMachine.tryState(RobotState.HAS_GP)));
    }
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured :3");
  }

}