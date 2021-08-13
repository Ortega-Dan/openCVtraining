package org.danort.facerecognition;

// import java.io.BufferedReader;
// import java.io.FileNotFoundException;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.ArrayList;

// import org.opencv.core.Core;
// import org.opencv.core.Mat;
// import org.opencv.core.MatOfInt;
// import org.opencv.face.EigenFaceRecognizer;
// import org.opencv.imgcodecs.Imgcodecs;

/**
 * THE PROGRAM IN THIS FILE IS INTENDED TO RECOGNIZE A SPECIFIC FACE RATHER THAN
 * DETECTING FACES
 */
public class FaceRecognitionEigenFaces {

	public static String csvFilePath = "src/main/java/resources/FaceRecognition/TrainingData.csv";

	// public static void main(String[] args) {
	// 	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	// 	System.out.println("Library loaded!!");
	// 	ArrayList<Mat> images = new ArrayList<>();
	// 	ArrayList<Integer> labels = new ArrayList<>();
	// 	readCSV(csvFilePath, images, labels);

	// 	Mat testSample = images.get(images.size() - 1);
	// 	Integer testLabel = labels.get(images.size() - 1);
	// 	images.remove(images.size() - 1);
	// 	labels.remove(labels.size() - 1);
	// 	MatOfInt labelsMat = new MatOfInt();
	// 	labelsMat.fromList(labels);
	// 	EigenFaceRecognizer efr = EigenFaceRecognizer.create();
	// 	System.out.println("Starting training...");
	// 	efr.train(images, labelsMat);

	// 	int[] outLabel = new int[1];
	// 	double[] outConf = new double[1];
	// 	System.out.println("Starting Prediction...");
	// 	efr.predict(testSample, outLabel, outConf);

	// 	System.out.println("***Predicted label is " + outLabel[0] + ".***");

	// 	System.out.println("***Actual label is " + testLabel + ".***");
	// 	System.out.println("***Confidence value is " + outConf[0] + ".***");

	// }

	// private static void readCSV(String csvFilePath2, ArrayList<Mat> images, ArrayList<Integer> labels) {
	// 	BufferedReader br;
	// 	try {
	// 		br = new BufferedReader(new FileReader(csvFilePath2));

	// 		String line;
	// 		while ((line = br.readLine()) != null) {
	// 			String[] tokens = line.split("\\;");
	// 			Mat readImage = Imgcodecs.imread(tokens[0], 0);
	// 			images.add(readImage);
	// 			labels.add(Integer.parseInt(tokens[1]));
	// 		}
	// 	} catch (FileNotFoundException e) {
	// 		e.printStackTrace();
	// 	} catch (NumberFormatException e) {
	// 		e.printStackTrace();
	// 	} catch (IOException e) {
	// 		e.printStackTrace();
	// 	}

	// }

}
