Remember to install mvn opencv jar with ...

mvn install:install-file -Dfile=lib/opencv-420.jar -DgroupId=opencv -DartifactId=opencv -Dversion=420 -Dpackaging=jar


This code is to be compiled and run with Java 13 or greater ... since the OpenCV java 
library was compiled with Java 13

...
Open cv code is from the following article by Manish Bansal
https://www.freecodecamp.org/news/facial-recognition-using-opencv-in-java-92fa40c22f62/
