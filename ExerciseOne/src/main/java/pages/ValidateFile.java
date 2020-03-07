package pages;

import exceptions.NoSuchFileException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ValidateFile {

  Scanner scan = new Scanner(System.in);
  Boolean fileExists = false;
  File newFile = null;
  String lineX = "";
  String testResult = null;
  ArrayList<String> errorMessages = new ArrayList<String>();
  ArrayList<String> errorMessagesActual = new ArrayList<String>();



  public void validateTxtFile(String txtName) throws NoSuchFileException, FileNotFoundException {
    String fullPath = "src/main/resources/" + txtName + ".txt";

    newFile = new File(fullPath);
    fileExists = newFile.exists();

    if (!fileExists) {
      throw new NoSuchFileException(txtName);
    }

    scan = new Scanner(newFile);

    for (int lineNumber = 1; scan.hasNext(); lineNumber++) {
      lineX = scan.nextLine();
      errorMessagesActual = validateLines(lineX, lineNumber);
    }

    logResults(errorMessagesActual);

  }

  private ArrayList<String> validateLines(String lineX, int lineNumber) {
    testResult = "PASSED";

    String [] parts;
    parts = lineX.split(" ");

    int actualLineNumber = Integer.parseInt(parts[0]);
    int numberValue = Integer.parseInt(parts[1]);

    if(actualLineNumber != lineNumber) {
      testResult = "FAIL";
      errorMessages.add("LINE NUMBER EXPECTED " + lineNumber + " BUT WAS " + actualLineNumber);
    }

    if(100 > numberValue || numberValue > 500) {
      testResult = "FAIL";
      errorMessages.add("NUMBER WAS NOT BETWEEN 100 and 500, ACTUAL NUMBER : " + numberValue);
    }
    return errorMessages;
  }

  private void logResults(ArrayList<String> errorMessages) {
    Logger logger = Logger.getLogger("MyLog");
    FileHandler fh;

    try {
      fh = new FileHandler("src/main/resources/results.log");
      logger.addHandler(fh);
      SimpleFormatter formatter = new SimpleFormatter();
      fh.setFormatter(formatter);

      logger.info(System.getProperty("fileName") + " " +testResult);
      if (errorMessages.size() > 0) {
        for (int i = 0; i < errorMessages.size(); i++) {
          logger.info(errorMessages.get(i));
        }
      }
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}