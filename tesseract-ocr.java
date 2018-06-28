import java.io.File;
import net.sourceforge.tess4j.*;

/*
=> Linux setup:

-Debian:
  $ sudo apt-get install tesseract-ocr tesseract-ocr-eng tesseract-ocr-por
-Redhat: 
  $ sudo yum install epel-release
  $ sudo yum install tesseract
Obs: I have NOT tried installing tesseract on Red Hat distributions. This might work or not. Hopefully it does :)

=> Maven setup:

<dependency>
    <groupId>net.sourceforge.tess4j</groupId>
    <artifactId>tess4j</artifactId>
    <version>3.2.1</version>
</dependency>

*/


public class TesseractExample {

    public static  void main(String[] args) {
        File imageFile = new File("/home/user/bla.png");
        ITesseract instance = new Tesseract(); 
        instance.setDatapath("/usr/share/tesseract-ocr"); //Where the tesseract data is installed. Common values are:
							  //   -  /usr/share/tesseract-ocr
                                                          //   -  /usr/share/tesseract 

        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }

}
