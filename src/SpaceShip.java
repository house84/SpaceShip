import java.util.*;

abstract class SpaceShip {

    //Variables of SpaceShip
    String name;            //Name
    int date;               //Build Date
    String designator;      //Hull Number
    int Coordinate_x;       //X Coordinate
    int Coordinate_y;       //Y Coordinate
    int Type;               //Ship Type, Cargo(2) or Pirate(1)
    int payload;            //Amount of Cargo or Booty on board


    SpaceShip(){}

    String getDesignator(){
        return designator;
    }

    //Set Date Ship Was Built
    void setDate(int date){ this.date = date; }

    //Get Ship Build Date
    public int getDate(){ return date; }

    //Set Name Method
    void setName(){
        System.out.println("What is this ships name? ");
        Scanner input = new Scanner(System.in);
        name = input.nextLine();
    }

    //Get Name
    public String getName(){ return name;}

    //Return toString - Name and Year of Ship
    public String toString() {
        return "Name: " +name + "    Hull Number: " +designator+"    Commissioned: " + date ;
    }

}
