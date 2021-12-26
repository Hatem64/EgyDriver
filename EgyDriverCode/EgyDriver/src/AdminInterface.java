import java.util.*;

public class AdminInterface {

  static void adminMenu() {
    Scanner in = new Scanner(System.in);
    ArrayList<DriverEntity> drivers = RegistrationForm.getRegisteredDriverList();

    boolean loop2 = true;
    while (loop2) {
      System.out.println("Please select which user are you going to login");
      System.out.println("1- List accepted drivers");
      System.out.println("2- List registered drivers");
      System.out.println("3- Accept drivers");
      System.out.println("4- List available locations");
      System.out.println("5- Add new locations");
      System.out.println("6- Logout");

      int cha = in.nextInt();
      in.nextLine();
      if (cha == 1) {
        if (Admin.getAccpetedDrivers().isEmpty()) {
          System.out.println();
          System.out.println("You have not accepted any drivers yet");
          System.out.println();
        } else
          Admin.printAccepptedDriverList();
      } else if (cha == 2) {
        System.out.println("there are " + drivers.size() + " registered Drivers");
        RegistrationForm.printRegisteredDriversList();
      } else if (cha == 3) {
        int num;
        boolean flep = true;
        while (flep) {
          System.out.println("Accept Driver:");
          num = in.nextInt();
          in.nextLine();
          Admin.addDriver(drivers.get(num - 1));
          if (RegistrationForm.getRegisteredDriverList().size() != 1) {
            System.out.println("Do you want to accept another driver? y/n");
            String decision = in.nextLine();
            if (decision.equalsIgnoreCase("y")) {
              flep = true;
            } else if (decision.equalsIgnoreCase("n")) {
              flep = false;
            } else
              System.out.println("error");
            flep = false;
          } else
            flep = false;

        }
      } else if (cha == 4) {
        Locations.listLocations();
      } else if (cha == 5) {
        String location = in.nextLine();
        Admin.addLocation(location);
      } else if (cha == 6) {
        LogoutInterface.logoutMenu();
      } else {
        System.out.println("Error has occured in the Admin Interface");
        adminMenu();
      }

    }
  }

}
