package org.danort;

import java.util.ArrayList;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import nu.pattern.OpenCV;

public class Tester {

    public static void main(String[] args) {

        OpenCV.loadShared();

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        System.out.println("\n\n");

        Mat img = Imgcodecs.imread("src/main/java/resources/Contours/someContours.png");

        Imgproc.cvtColor(img, img, Imgproc.COLOR_BGR2GRAY);

        Imgproc.threshold(img, img, 200, 255, Imgproc.THRESH_BINARY_INV);

        var conts = new ArrayList<MatOfPoint>();

        Imgproc.findContours(img, conts, new Mat(), Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_NONE);

        var sels = new ArrayList<MatOfPoint>();

        System.out.println(conts.size());
        for (MatOfPoint cont : conts) {

            if (Imgproc.contourArea(cont) > 3000) {
                System.out.println(1);
                sels.add(cont);
            }

        }

        Imgproc.cvtColor(img, img, Imgproc.COLOR_GRAY2BGR);

        Imgproc.drawContours(img, sels, -1, new Scalar(0, 255,0), 5);
        // Imgproc.fillPoly(img, sels, new Scalar(0, 0, 0));

        // Core.bitwise_not(img, img);

        Imgcodecs.imwrite("out.png", img);

    }

}
