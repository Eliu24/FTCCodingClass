package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.internal.android.dx.cf.attrib.AttEnclosingMethod;


@TeleOp
public class HW1 extends OpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;

    @Override
    public void init(){
        leftDrive = hardwareMap.get(DcMotor.class, "leftDrive");
        rightDrive = hardwareMap.get(DcMotor.class, "rightDrive");

        leftDrive.setDirection(DcMotorSimple.Direction.FORWARD);
        rightDrive.setDirection(DcMotorSimple.Direction.REVERSE);

    }
    @Override
    public void init_loop() {

    }
    @Override
    public void start() {
        runtime.reset();
    }
    @Override
    public void loop(){
        double leftPower;
        double rightPower;

        double drive = gamepad1.left_stick_x;
        double turn = gamepad1.right_stick_y;
        leftPower = Range.clip(drive+turn, -1.0, 1.0);
        rightPower = Range.clip(drive - turn,-1.0, 1.0);

        telemetry.addData("Status", "Runtime" + runtime.toString());
        telemetry.addData("Motors", "left(%.2f), right(%.2f)" + leftPower, rightPower);
    }
    @Override
    public void stop() {

    }
}
