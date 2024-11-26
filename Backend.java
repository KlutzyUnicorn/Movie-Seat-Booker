import java.util.*;

public class Backend {
  Scanner reader = new Scanner(System.in);

  public void clear() {
    // clears the console
    System.out.print("\033[H\033[2J");
  }// end clear method

  public void wait(int sec) {
    // creates a pause before the next line of code is executed
    try {
      Thread.sleep(sec * 1000);
    }
    // end try
    catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
    }
    // end catch
  }// end wait method

  public void quit() {
    // ends program
    System.exit(0);
  }// end quit

  public void inputerror() {
    // an error that is printed whenever the input is not on of the ones that was
    // set
    System.out.println("\033[31mError Input Not Recognized\033[37m");
    wait(1);
    clear();
  }// end inputerror

  public void next() {
    // creates a message that prompts the user to press enter to move on to the next
    // thing
    wait(1);
    System.out.println("\n\033[34m(press \"ENTER\" to continue)\033[37m");
    reader.nextLine();
    clear();
  }// end next

  public int menuinput() {
    String input = reader.nextLine();
    try {
      return Integer.parseInt(input);
    } // end try
    catch (NumberFormatException e) {
      return -1;
    } // end catch
  }// end menu input
}// end backend class