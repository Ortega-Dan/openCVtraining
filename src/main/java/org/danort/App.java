package org.danort;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        // This only tests the loading of the java library (.jar) and the native
        // java-binder library (.so or .dll) which must be found by the system path
        // environment variable and is provided from the opencv installation

        // but this simple main method doesn't test the use of the actual progra ...
        // which must be installed and found by the path as well

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
        System.out.println("mat = " + mat.dump());

    }
}
