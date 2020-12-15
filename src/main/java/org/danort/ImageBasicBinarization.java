package org.danort;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ImageBasicBinarization {

    public static void main(String[] args) {

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        String fileIn = "/home/danort/Documents/vscodeprojects/python/pythonAndCVImageThresholding/finalDeskewed1.png";
        String fileOut = "/home/danort/Documents/vscodeprojects/python/pythonAndCVImageThresholding/finalDeskewed2.png";

        Mat image = Imgcodecs.imread(fileIn);

        Mat image2 = new Mat(image.size(), image.type());

        // Imgproc.threshold(image, image2, 127, 255, Imgproc.THRESH_BINARY);
        // Imgproc.threshold(image, image2, 127, 255, Imgproc.THRESH_BINARY_INV);
        // Imgproc.threshold(image, image2, 127, 255, Imgproc.THRESH_TOZERO);
        Imgproc.threshold(image, image2, 127, 255, Imgproc.THRESH_TOZERO_INV);
        // Imgproc.threshold(image, image2, 127, 255, Imgproc.THRESH_TRUNC);

        Imgcodecs.imwrite(fileOut, image2);

    }

}
