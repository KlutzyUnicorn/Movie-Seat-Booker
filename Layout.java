class Layout {
  public void printseating(String[][] seats) {
    // prints out the seats
    System.out.println("\t\t\t\t\t\t\t\tScreen\n");
    for (int row = 0; row < seats.length; row++) {
      for (int col = 0; col < seats[0].length; col++) {
        if (row == 0 && col == 1) {
          // tabs the A so that all the letters line up with other rows
          System.out.print("\t");
        }
        if (col == 4 || col == 11) {
          // creates tabs to look like aisles
          System.out.print("\t");
        } // end else
        System.out.print(seats[row][col]);

        if (row == 0 && col == seats[0].length - 1) {
          // creates a space between the letters and the seats
          System.out.println();
        }
      } // end for
      System.out.println();
    } // end for
    // creates a legend at the bottom
    System.out.print("\n[ ] Available\t[X] Booked\t[\033[32mX\033[37m] Your Booked Seat");
  }// end printseating
}// end layout