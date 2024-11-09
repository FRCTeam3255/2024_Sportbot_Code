// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/** Contains all ports on our robot */
public class RobotMap {

  public static class mapControllers {
    public static final int DRIVER_USB = 0;
    public static final int OPERATOR_USB = 1;
  }

  public static class mapHopper {
    public static final int HOPPER_MOTOR = 30;
    public static final int GAME_PIECE_HOPPER_DIO = 1;
    public static final int FULL_HOPPER_DIO = 2;
  }

  public static class mapDriveTrain {
    // Motor ID's
    public static final int FRONT_RIGHT_MOTOR = 0;
    public static final int BACK_RIGHT_MOTOR = 1;
    public static final int FRONT_LEFT_MOTOR = 2;
    public static final int BACK_LEFT_MOTOR = 3;
  }

  public static class mapIntake {
    public static final int INTAKE_MOTOR_CAN = 20;
  }

  public static class mapShooter {
    public static final int PROPEL_MOTOR_CAN = 10;
    public static final int SPIRAL_MOTOR_CAN = 11;
  }

  public static class mapStager {
    public static final int CONVEYOR_MOTOR_CAN = 40;
    public static final int IS_GP_STAGED_DIO = 0;
  }

}
