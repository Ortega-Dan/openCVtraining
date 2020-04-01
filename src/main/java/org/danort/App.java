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

        // This tests the loading of the java library (.jar) and the native
        // java-binder library (.so or .dll)

        // The native native java-binder library must be found by the system from path
        // or the execution directory

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
        System.out.println("mat = " + mat.dump());

    }
}
