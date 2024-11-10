// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
// import com.ctre.phoenix6.hardwareTalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
  TalonSRX propelMotor;
  TalonSRX spiralMotor;

  public Shooter() {
    propelMotor = new TalonSRX(RobotMap.mapShooter.PROPEL_MOTOR_CAN);
    spiralMotor = new TalonSRX(RobotMap.mapShooter.SPIRAL_MOTOR_CAN);
  }

  public void setSpiralMotorVelocity(double velocity) {
    spiralMotor.set(ControlMode.PercentOutput, velocity);
  }

  public double getSpiralMotorVelocity() {
    return spiralMotor.getMotorOutputVoltage();
  }

  public void setPropelMotorVelocity(double velocity) {
    propelMotor.set(ControlMode.PercentOutput, velocity);
  }

  public double getPropelMotorVelocity() {
    return propelMotor.getMotorOutputVoltage();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("propelMotorSpeed", getPropelMotorVelocity());
    SmartDashboard.putNumber("spiralMotorSpeed", getSpiralMotorVelocity());
  }
}
