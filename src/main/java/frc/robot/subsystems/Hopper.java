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
  TalonFX HopperMotor;
  DigitalInput HopperSensor;

  DigitalInput FullHopperSensor;


  public Hopper() {
    HopperMotor = new TalonFX(RobotMap.mapHopper.HOPPER_MOTOR);
    HopperSensor = new DigitalInput(RobotMap.mapHopper.GAME_PIECE_HOPPER_DIO);

    FullHopperSensor = new DigitalInput(RobotMap.mapHopper.FULL_HOPPER_DIO);

  }

  public void setHopperMotorSpeed(double speed) {
    HopperMotor.set(speed);
  }

  public void setHopperMotorNuetralOutput() {
    HopperMotor.set(0);
  }


  public boolean getGamePieceHopper() {

    return HopperSensor.get();
  }

  public boolean isHopperFull() {

    return FullHopperSensor.get();
  }


  @Override
  public void periodic() {

  }
}
