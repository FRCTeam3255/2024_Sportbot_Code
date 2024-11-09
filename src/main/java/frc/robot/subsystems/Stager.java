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
  TalonFX stagerMotor;
  DigitalInput hasGP;

  public Stager() {
    stagerMotor = new TalonFX(RobotMap.mapStager.STAGER_MOTOR_CAN);
    hasGP = new DigitalInput(RobotMap.mapStager.HAS_GP_DIO);
  }

  public void setConveyorMotorVelocity(double velocity) {
    stagerMotor.set(velocity);
  }

  public void setConveyorMotorVelocityNuetralOutput() {
    stagerMotor.set(0);
  }

  public boolean getHasGP() {
    return hasGP.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
