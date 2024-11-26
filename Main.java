import java.util.*;

class Main {
  public static void main(String[] args) {
    // creating objects
    Backend backEnd = new Backend();
    Layout layout = new Layout();
    Scanner nextReader = new Scanner(System.in);
    Scanner lineReader = new Scanner(System.in);
    Random random = new Random();

    // creates the 2d array for the seating
    String[][] seats = new String[13][14];
    // creates arraylists to store the numbers and letters corresponding to the
    // seats
    ArrayList<String> seatRows = new ArrayList<String>();
    ArrayList<String> seatColumns = new ArrayList<String>();

    seats[0][0] = "";
    char letter = 'A';
    for (int col = 1; col < seats[0].length; col++) {
      // fills the first row with letters and one of the arraylists with the letters
      seats[0][col] = "  " + String.valueOf(letter) + "  ";
      seatColumns.add(String.valueOf(letter));
      letter++;
    } // end for
    for (int row = 1; row < seats.length; row++) {
      // fills the first column with numbers and the other arraylist with the numbers
      seats[row][0] = String.valueOf(row) + "\t";
      seatRows.add(String.valueOf(row));
    } // end for
    for (int row = 1; row < seats.length; row++) {
      for (int col = 1; col < seats[0].length; col++) {
        // fills everything else with [X] and [ ] randomly
        int num = random.nextInt(100);
        if (num <= 30) {
          seats[row][col] = " [X] ";
        } // end if
        else {
          seats[row][col] = " [ ] ";
        } // end else if
      } // end for
    } // end for

    backEnd.clear();

    while (true) {
      // main menu
      System.out.println("\t\"Belle\" Ticket Booking");
      System.out.println(
          "\n1. Book A Seat" +
              "\n2. Preview Seats" +
              "\n3. Exit\n");
      System.out.print("\033[34mEnter Number:\033[37m\t");
      int input = backEnd.menuinput();

      switch (input) {
        case 1:
          // Book A Seat
          loop: while (true) {
            backEnd.clear();
            System.out.println("\tBook A Seat\n");
            System.out.println("To book a seat please enter the seat's number and letter, eg. \"1A\"");
            System.out.println("Or if you would like to return to the main menu enter \"back\"\n");
            layout.printseating(seats);
            System.out.print("\n\n\033[34mEnter Seat:\033[37m\t");
            String seat = lineReader.nextLine();

            if (seatRows.contains(seat.substring(0, seat.length() - 1))
                && seatColumns.contains(seat.substring(seat.length() - 1, seat.length()).toUpperCase())) {
              // checks if the input exists as a seat using the arraylists
              // finds and stores the index of the seat
              int seatrow = seatRows.indexOf(seat.substring(0, seat.length() - 1)) + 1;
              int seatcol = seatColumns.indexOf(seat.substring(seat.length() - 1, seat.length()).toUpperCase()) + 1;
              /*
               * System.out.println(seatrow);
               * System.out.println(seatcol);
               * backEnd.next();
               */

              if (seats[seatrow][seatcol].equals(" [ ] ")) {
                // checks if the seat is available
                seats[seatrow][seatcol] = " \033[34m[X]\033[37m ";
                backEnd.clear();
                System.out.println("\tBook A Seat\n");
                layout.printseating(seats);
                System.out.print("\t\033[34m[X]\033[37m Currently Selected\n");
                System.out.print("\n\033[34mWould You Like To Book This Seat? (y/n):\t\033[37m");
                char book = nextReader.next().charAt(0);

                // switch for confirmation if the user want to book that seat
                switch (book) {
                  case 'y':
                  case 'Y':
                    seats[seatrow][seatcol] = " [\033[32mX\033[37m] ";
                    backEnd.clear();
                    System.out.println("\tBook A Seat\n");
                    layout.printseating(seats);
                    System.out.println();
                    backEnd.next();
                    backEnd.clear();
                    break loop;

                  case 'n':
                  case 'N':
                    seats[seatrow][seatcol] = " [ ] ";
                    backEnd.clear();
                    break loop;

                  default:
                    // error
                    seats[seatrow][seatcol] = " [ ] ";
                    backEnd.inputerror();
                    continue;
                }// end switch
              } // end if
              else {
                // the seat is already booked
                System.out.println("\033[31mSeat Is Already Booked\033[37m");
                backEnd.wait(1);
                backEnd.clear();
                continue;
              } // end else
                // System.out.print(seatrow + seatcol);
                // backEnd.next();
            } // end if
            else if (seat.toLowerCase().equals("back")) {
              // send the user back to the main menu
              backEnd.clear();
              break loop;
            } // end else if
            else {
              // error
              backEnd.inputerror();
            } // end else
          } // end while
          continue;

        case 2:
          // allows the user to preview the seats
          backEnd.clear();
          System.out.println("\tPreview Seats\n");
          layout.printseating(seats);
          System.out.println();
          backEnd.next();
          continue;

        case 3:
          // exit the program
          backEnd.clear();
          backEnd.quit();
          break;

        default:
          // error
          backEnd.inputerror();
          continue;
      }// end switch

    } // end while
      // layout.printseating(seats);
      // layout.printseating(seats);
  } // end main method
} // end main