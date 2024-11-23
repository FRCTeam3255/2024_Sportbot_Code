// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
// import com.ctre.phoenix6.hardware.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Stager extends SubsystemBase {
  /** Creates a new Stager. */
  TalonSRX stagerMotor;
  TalonSRX topStagerMotor;
  DigitalInput hasGP;

  public Stager() {
    stagerMotor = new TalonSRX(RobotMap.mapStager.STAGER_MOTOR_CAN);
    topStagerMotor = new TalonSRX(RobotMap.mapStager.TOP_STAGER_MOTOR_CAN);
    hasGP = new DigitalInput(RobotMap.mapStager.HAS_GP_DIO);
  }

  public void setStagerMotorVelocity(double velocity) {
    stagerMotor.set(ControlMode.PercentOutput, velocity);
  }

  public void setTopStagerMotorVelocity(double velocity) {
    topStagerMotor.set(ControlMode.PercentOutput, velocity);
  }

  public void setStagerMotorVelocityNuetralOutput() {
    stagerMotor.set(ControlMode.PercentOutput, 0);
    topStagerMotor.set(ControlMode.PercentOutput, 0);
  }

  public boolean getHasGP() {
    return hasGP.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("hasGP", !getHasGP());
  }
}
