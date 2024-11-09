// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
  TalonFX propelMotor;
  TalonFX spiralMotor;

  public Shooter() {
    propelMotor = new TalonFX(RobotMap.mapShooter.PROPEL_MOTOR_CAN);
    spiralMotor = new TalonFX(RobotMap.mapShooter.SPIRAL_MOTOR_CAN);
  }

  public void setSpiralMotorVelocity(double velocity) {
    spiralMotor.set(velocity);
  }

  public double getSpiralMotorVelocity() {
    return spiralMotor.get();
  }

  public void setPropelMotorVelocity(double velocity) {
    propelMotor.set(velocity);
  }

  public double getPropelMotorVelocity() {
    return propelMotor.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
