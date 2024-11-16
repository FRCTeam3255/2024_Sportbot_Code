// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Hopper extends SubsystemBase {
  /** Creates a new Hopper. */
  TalonSRX orientationMotor;
  DigitalInput isGPDetected;

  public Hopper() {
    orientationMotor = new TalonSRX(RobotMap.mapHopper.ORIENTATION_MOTOR);
    isGPDetected = new DigitalInput(RobotMap.mapHopper.IS_GP_DETECTED_DIO);

  }

  public void setOrientationMotorSpeed(double velocity) {
    orientationMotor.set(ControlMode.PercentOutput, velocity);
  }

  public void setOrientationMotorNuetralOutput() {
    orientationMotor.set(ControlMode.PercentOutput, 0);
  }

  public boolean getGamePieceHopper() {

    return isGPDetected.get();
  }

  @Override
  public void periodic() {

  }
}
