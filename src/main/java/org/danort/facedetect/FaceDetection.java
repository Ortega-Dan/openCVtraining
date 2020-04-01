package org.danort.facedetect;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.danort.utils.Utils;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.objdetect.Objdetect;

/**
 * THE PROGRAM IN THIS FILE IS INTENDED TO JUST RECOGNIZE FACES IN IMAGES FROM
 * AN OPENCV PRETRAINED MODEL OF FACES
 */
public class FaceDetection {

	public static String classifierPath1;
	public static String inpImgFilename;
	public static String opImgFilename;

	public static void main(String[] args) {
		try {

			// path to the pretrained model, more models are found somewhere within opencv
			// installed files under "haarcascades" directory
			classifierPath1 = "src/main/java/resources/FaceDetection/haarcascade_frontalface_alt.xml";
			inpImgFilename = "src/main/java/resources/FaceDetection/input1.jpg";
			// inpImgFilename = "src/main/java/resources/FaceDetection/input2.jpg";
			opImgFilename = "src/main/java/resources/FaceDetection/output.jpg";

			// classifierPath1 = args[0];
			// inpImgFilename = args[1];
			// opImgFilename = args[2];

			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
			System.out.println("Library loaded..");
			Mat frame = Imgcodecs.imread(inpImgFilename, 1);
			if (!frame.empty()) {
				// face detection
				detectAndDisplay(frame);
				File outputfile = new File(opImgFilename);
				ImageIO.write(Utils.matToBufferedImage(frame), "jpg", outputfile);
				System.out.println("Done!!");
			}
		} catch (IOException e) {
			System.out.println("Exception IO");
			e.printStackTrace();
		}
	}

	public static void detectAndDisplay(Mat frame) throws IOException {
		MatOfRect faces = new MatOfRect();
		Mat grayFrame = new Mat();
		int absoluteFaceSize = 0;
		CascadeClassifier faceCascade = new CascadeClassifier();

		faceCascade.load(classifierPath1);
		// convert the frame in gray scale
		Imgproc.cvtColor(frame, grayFrame, Imgproc.COLOR_BGR2GRAY);
		// equalize the frame histogram to improve the result
		Imgproc.equalizeHist(grayFrame, grayFrame);

		// compute minimum face size (1% of the frame height, in our case)

		int height = grayFrame.rows();
		if (Math.round(height * 0.2f) > 0) {
			absoluteFaceSize = Math.round(height * 0.01f);
		}

		// detect faces
		faceCascade.detectMultiScale(grayFrame, faces, 1.1, 2, 0 | Objdetect.CASCADE_SCALE_IMAGE,
				new Size(absoluteFaceSize, absoluteFaceSize), new Size(height, height));

		// each rectangle in faces is a face: draw them!
		Rect[] facesArray = faces.toArray();
		System.out.println("Number of faces detected = " + facesArray.length);
		for (int i = 0; i < facesArray.length; i++)
			Imgproc.rectangle(frame, facesArray[i].tl(), facesArray[i].br(), new Scalar(0, 255, 0), 2);

	}

}
