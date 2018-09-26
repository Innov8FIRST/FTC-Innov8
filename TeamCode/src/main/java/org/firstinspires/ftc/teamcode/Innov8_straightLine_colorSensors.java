package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Innov8_straightLine_colorSensors", group = "Auto")

public class Innov8_straightLine_colorSensors extends LinearOpMode {

    /* Declare OpMode members. */
    HardwareInnov8Duck robot = new HardwareInnov8Duck();   // Use Duck's hardware

    /*Declare variables */
    double startPositionR = 0;
    double startPositionL = 0; // the left encoder is placed backwards
    double endPositionR = 0;
    double endPositionL = 0;
    double MID_SERVO = 0.3;
    double START_SERVO = 0;
    double END_SERVO = 0.9;
    int Time = 0;
    int FDrive = 2;
    int teamColor = 0;   //0 = red   or 1 = blue
    int taskNumber = 0;   //used to determine the step that should be executed
    double multR = 0.1;
    double multL = 0.02;
    double correctL = 1;  // 1 or -1
    double correctR = 1;  //1 or -1

    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);                                // Servo mid position

        startPositionR = robot.rightMotor.getCurrentPosition();
        startPositionL = robot.leftMotor.getCurrentPosition();
        telemetry.addData("startR", startPositionR);
        telemetry.addData("startL", startPositionL);
        telemetry.addData("CurrentR", robot.rightMotor.getCurrentPosition());
        telemetry.addData("CurrentL", robot.leftMotor.getCurrentPosition());
        telemetry.addData("EndR", endPositionR);
        telemetry.addData("EndL", endPositionL);
        telemetry.addData("RightPower",robot.rightMotor.getPower());
        telemetry.addData("LeftPower",robot.leftMotor.getPower());
        telemetry.update();



        waitForStart();


        while (opModeIsActive() && taskNumber != 9999) {
            telemetry.addData("Case", taskNumber);
            telemetry.addData("RightRed", robot.rightFruity.red());
            telemetry.addData("RightBlue", robot.rightFruity.blue());
            telemetry.addData("right", robot.rightMotor.getCurrentPosition());
            telemetry.addData("left", robot.leftMotor.getCurrentPosition());
            telemetry.addData("startR", startPositionR);
            telemetry.addData("endR", endPositionR);
            telemetry.addData("LeftRed", robot.leftFruity.red());
            telemetry.addData("LeftBlue", robot.leftFruity.blue());
            telemetry.addData("startL", startPositionL);
            telemetry.addData("endL", endPositionL);
            telemetry.addData("RightPower",robot.rightMotor.getPower());
            telemetry.addData("LeftPower",robot.leftMotor.getPower());
            telemetry.update();

            robot.rightMotor.setPower(10 * multR * correctR);
            robot.leftMotor.setPower(10 * multL * correctL);

            while  (robot.leftMotor.getPower() != 0 || robot.rightMotor.getPower() != 0)  {

                telemetry.update();

                if (robot.rightFruity.red() >= 450) {

                    robot.rightMotor.setPower(0);
                }

                if (robot.leftFruity.red() >= 300) {

                    robot.leftMotor.setPower(0);
                }



            taskNumber = 9999;
            }
        }
    }
}