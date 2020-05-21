import java.text.*;
import java.util.*;

public class SpaceProject {
    public static void main(String[] args) {


        //Set Designator Incrementing variables.
        int CargoDesignator = 1, PirateDesignator = 1;
        String designator = null;   //String designator for Each ship

        Scanner input = new Scanner(System.in);

        //Create ArrayList to hold SpaceShips
        SpaceShip S;
        ArrayList<SpaceShip> spaceShips = new ArrayList<>(10);

        //Validate user input for number of ships to be built
        int n = 0;
        while (n < 1 || n > 9) {
            System.out.println("Enter the number of spaceships you would like, 1-9. ");
            n = input.nextInt();
        }

        //Create List of Spaceships
        for (int i = 0; i < n; i++) {
            System.out.println("For ship " + (i + 1) + ", enter one or two for the type" +
                    "of ship you would like to build. \n1) Cargo Ship \n2) Pirate Ship ");

            //Validate User Input
            int choice = 0;
            while (choice < 1 || choice > 2) {
                System.out.println("Choose 1 or 2: ");
                choice = input.nextInt();
            }

            //Call on Method to get a build Date in the future, Checked with current date
            int built = getDate();

            //Choose Type of Ship
            if (choice == 1) {
                designator = "C" +CargoDesignator;
                spaceShips.add(S = new CargoShip(built, designator));
                CargoDesignator++;
            }
            else {
                designator = "P" +PirateDesignator;
                spaceShips.add(S = new PirateShip(built, designator));
                PirateDesignator++;
            }
        }

        int play = 0; //Continue to play
        //Play Interface
        while(play == 0) {

            //Message Index
            int CrashCourse = 0;

            //Formatting Line Space
            System.out.println();

            //Display World
            System.out.println("________________SPACE WORLD_______________");

            //Display World and All ships
            //Go through Rows
            for (int i = 9; i >= 0; i--) {

                String Display = null;              //Output String for each coordinate

                //Display y Axis values
                System.out.print(i + " ");

                //Go through Columns
                for (int j = 0; j < 10; j++) {

                    int a = 0;    //Index variable to see if spaceship is in coordinate
                    int crash = 0;             //Check for two ships in same coordinate

                    //Check array for Spaceships in (j,i) Location
                    for (SpaceShip spaceShip : spaceShips) {

                        int y = spaceShip.Coordinate_y;      //get coordinate Y
                        int x = spaceShip.Coordinate_x;      //get coordinate x
                        int type = spaceShip.Type;           //get spaceship type


                        //Check Position of Cargo Ships and Display Designator
                        if (i == y && j == x && type == 2) {
                            Display = "|" + spaceShip.getDesignator() + "|";
                            a = 1;
                            crash += 1;
                        }
                        //Check position of Pirate Ships and Display Designator
                        if (i == y && j == x && type == 1) {
                            Display = "|" + spaceShip.getDesignator() + "|";
                            a = 1;
                            crash += 1;
                        }

                    }
                    //Check for Collision (More than one ship per coordinate)
                    if (crash == 2) {
                        Display = "Crash";
                    }
                    if (crash > 2) {
                        Display = "CRASH";
                        CrashCourse = crash;
                    }
                    //Display ship type or no ship
                    if (a > 0) {
                        System.out.print(Display);
                    }
                    //Display Normal Empty Coordinate Graphic
                    else {
                        System.out.print("|**|");
                    }
                }

                System.out.println();       //Formatting
            }

            //Display X Axis Values
            System.out.println("   0   1   2   3   4   5   6   7   8   9 \n");

            if(CrashCourse == 3 ){      //Ridiculous Crash Comment
                System.out.println("How did you get more than two ships to crash?  \n" +
                        "Maybe it's time to go back to flying school...\n");
            }
            if(CrashCourse > 3 ){       //Ridiculous Crash Comment
                System.out.println("How did you get more than two ships to crash?  \n" +
                        "Maybe it's time to go back to flying school...\n");
                System.out.println("That is a lot of crashed ships...somebodies getting fired for sure.\n");

            }

            //Call toStrings for all Ships
            for (SpaceShip spaceShip : spaceShips) {
                System.out.println(spaceShip.toString());
            }

            //Continue or Exit
            System.out.println("Enter 1: To change a status of a ship or Enter 2: To Exit the game ");
            //Validate Input
            int choice = 0;
            while (choice < 1 || choice > 2) {
                System.out.print("Select 1 or 2: ");
                choice = input.nextInt();
            }

            //Exit Game
            if(choice == 2){
                System.out.println("Thanks for Playing! ");
                play = 1; }

            //Continue to Play
            else{
                System.out.println("---Select the Hull number of the ship you would like to change---");
                //Display Hull Numbers for user choice
                for(int i = 0; i<spaceShips.size(); i++){
                    System.out.print((i+1) + ": " +spaceShips.get(i).getDesignator()+"    ");
                }

                //Validate Ship Choice
                int index = -1;
                int ship = 0;       //Condition integer
                while(ship < 1 || ship > spaceShips.size()){
                    System.out.print("\nChoose a Ship 1 to " + spaceShips.size()+": ");
                    ship = input.nextInt();
                    index = ship-1;
                }

                //Choose Action
                System.out.println("Enter 1: Change Ship Type    Enter 2: Move Ship ");
                int action = 0;
                //Validate Input
                while(action < 1 || action > 2){
                    action  = input.nextInt();
                }
                //Execute User Decision
                switch(action) {
                    case 1: //Convert Ship Type
                        //Convert Cargo Ship into Pirate Ship
                        if (spaceShips.get(index).Type == 2) {
                            spaceShips.set(index, new PirateShip(spaceShips.get(index), PirateDesignator));
                            PirateDesignator++;
                            break;
                        }
                        //Convert Pirate Ship into Cargo Ship
                        if (spaceShips.get(index).Type == 1) {
                            spaceShips.set(index, new CargoShip(spaceShips.get(index), CargoDesignator));
                            CargoDesignator++;
                            break;
                        }
                    case 2: //Move Ship
                        //Prompt for User input and validate
                        System.out.println("Enter the X and Y Coordinates you would like" +
                                "to move your ship to: ");
                        //Enter X value and Validate
                        int x = -1;
                        while(x<0 || x > 9){
                            System.out.print("Enter X coordinate (0-9)");
                            x = input.nextInt();
                        }
                        //Enter Y value and Validate
                        int y = -1;
                        while(y < 0 || y > 9){
                            System.out.print("Enter Y coordinate (0-9)");
                            y = input.nextInt();
                        }
                        //Set Coordinates if Cargo Ship
                        if(spaceShips.get(index) instanceof CargoShip) {
                            ((CargoShip) spaceShips.get(index)).moveShip(x, y);
                        }
                        //Set Coordinates if Pirate Ship
                        if(spaceShips.get(index) instanceof  PirateShip){
                            ((PirateShip) spaceShips.get(index)).moveShip(x,y);

                        }
                        break;

                        default:
                        break;

                }
            }
        }
    }

    private static int getDate(){
        //Get Current Year and convert to an integer to validate build dates.
        Date date;
        DateFormat DF = new SimpleDateFormat("yyyy");
        date = new Date();                      //Set Date to current year
        String format = DF.format(date);        //Set date to format
        int year = Integer.parseInt(format);    //Typecast format to an integer
        Scanner input = new Scanner(System.in);

        //Take Date and validate for future year.
        int built = 0;                          //Ship Build Date Variable
        while (built < year) {
            System.out.println("What date was this ship built (must be a 4 digit year in the future.) ");
            built = input.nextInt();
        }

        //Return ships build date
        return built;
    }

}
