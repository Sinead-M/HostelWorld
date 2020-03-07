package tests;

import exceptions.NoSuchFileException;
import java.io.IOException;
import org.testng.annotations.Test;
import pages.ValidateFile;

public class NumberFileAT {

  private ValidateFile validateFile;

  @Test()
  public void validateNumberFiles() throws NoSuchFileException, IOException {
    validateFile = new ValidateFile();
    validateFile.validateTxtFile(System.getProperty("fileName"));
  }
}
