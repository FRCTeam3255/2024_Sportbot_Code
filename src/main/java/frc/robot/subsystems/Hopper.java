// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Hopper extends SubsystemBase {
  /** Creates a new Hopper. */
  TalonFX orientationMotor;
  DigitalInput isGPDetected;
  DigitalInput isHopperFull;

  public Hopper() {
    orientationMotor = new TalonFX(RobotMap.mapHopper.ORIENTATION_MOTOR);
    isGPDetected = new DigitalInput(RobotMap.mapHopper.IS_GP_DETECTED_DIO);
    isHopperFull = new DigitalInput(RobotMap.mapHopper.IS_HOPPER_FULL_DIO);

  }

  public void setHopperMotorSpeed(double speed) {
    orientationMotor.set(speed);
  }

  public void setHopperMotorNuetralOutput() {
    orientationMotor.set(0);
  }

  public boolean getGamePieceHopper() {

    return isGPDetected.get();
  }

  public boolean isHopperFull() {

    return isHopperFull.get();
  }

  @Override
  public void periodic() {

  }
}
