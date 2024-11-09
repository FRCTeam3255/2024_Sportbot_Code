// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Stager extends SubsystemBase {
  /** Creates a new Stager. */
  TalonFX conveyorMotor;
  DigitalInput isGPStaged;

  public Stager() {
    conveyorMotor = new TalonFX(RobotMap.mapStager.CONVEYOR_MOTOR_CAN);
    isGPStaged = new DigitalInput(RobotMap.mapStager.IS_GP_STAGED_DIO);
  }

  public void setConveyorMotorVelocity(double velocity) {
    conveyorMotor.set(velocity);
  }

  public void setConveyorMotorVelocityNuetralOutput() {
    conveyorMotor.set(0);
  }

  public boolean getIsGPStaged() {
    return isGPStaged.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
