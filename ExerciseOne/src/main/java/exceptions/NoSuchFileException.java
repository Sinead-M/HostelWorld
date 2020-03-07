package exceptions;

public class NoSuchFileException extends Exception {

  public NoSuchFileException(String name) { super("TEXT FILE NOT FOUND : " + name);}

}
