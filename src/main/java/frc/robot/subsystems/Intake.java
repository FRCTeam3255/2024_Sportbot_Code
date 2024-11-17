// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  TalonFX intakeMotor;

  public Intake() {
    intakeMotor = new TalonFX(RobotMap.mapIntake.INTAKE_MOTOR_CAN);
  }

  public void setIntakeVelocity(double velocity) {
    intakeMotor.set(velocity);

  }

  public void setIntakeNuetralOutput() {
    intakeMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
