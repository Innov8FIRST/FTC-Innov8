package ftc.vision;

import android.view.View;

import org.opencv.android.CameraBridgeViewBase;
import org.opencv.core.Mat;

public class FrameGrabber implements
        CameraBridgeViewBase.CvCameraViewListener2 {

    public FrameGrabber(CameraBridgeViewBase c) {
        c.setVisibility(View.VISIBLE);
        c.setCvCameraViewListener(this);
    }

    @Override
    public void onCameraViewStarted(int width, int height) {
    }

    @Override
    public void onCameraViewStopped() {

    }

    @Override
    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
        return inputFrame.rgba();
    }
}
