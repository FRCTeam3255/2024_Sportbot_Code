// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  TalonFX topMotor;
  TalonFX bottomMotor;

  public Intake() {
    topMotor = new TalonFX(RobotMap.mapIntake.TOP_MOTOR_CAN);
    bottomMotor = new TalonFX(RobotMap.mapIntake.BOTTOM_MOTOR_CAN);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
