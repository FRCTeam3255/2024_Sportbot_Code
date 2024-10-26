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
  TalonFX shootMotor;

  public Shooter() {
    propelMotor = new TalonFX(RobotMap.mapShooter.PROPEL_MOTOR_CAN);
    shootMotor = new TalonFX(RobotMap.mapShooter.SHOOT_MOTOR_CAN);
  }

  public void setShooterVelocity(double velocity) {
    shootMotor.set(velocity);
  }

  public double getShooterVelocity() {
    return shootMotor.get();
  }

  public void setPropelVelocity(double velocity) {
    propelMotor.set(velocity);
  }

  public double getPropelVelocity() {
    return propelMotor.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
