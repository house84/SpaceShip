public class PirateShip extends SpaceShip implements CanMove {

    //Variables
    private int booty;

    //Constructor
    PirateShip(int Date, String designator){
        setDate(Date);                     //Set Build Date
        setName();                         //Set Name
        Set_Coordinates();                 //Set Initial Coordinates (random)
        this.designator = designator;      //Assign Hull Number
        setBooty();                        //Set Amount of Booty
        setType();                         //Set Ship Type to 1
    }

    //Ship Conversion Constructor
    PirateShip(SpaceShip converted, int designator){
        this.designator = "P"+ designator;                          //Assign new Pirate Hull Number
        moveShip(converted.Coordinate_x, converted.Coordinate_y);   //Set Current Coordinates
        this.date = converted.date;                                 //Copy Original Build Date
        this.name = converted.name;                                 //Copy Name
        setPayloadandBooty(converted.payload);                      //Change Cargo to Booty and Set Payload
        setType();                                                  //Change Type to 1
    }

    //Value to identify what type of ship Pirate Ship is type 1
    private void setType(){ Type = 1; }

    @Override   //Change coordinates of Ship
    public void moveShip(int x, int y){
        Coordinate_x = x;
        Coordinate_y = y;
    }

    //Set the Ships initial Coordinates
    private void Set_Coordinates(){
        Coordinate_x = (int)(Math.random()*9);
        Coordinate_y = (int)(Math.random()*9);
    }

    //Set Ships initial Booty Randomly
    private void setBooty(){
        booty = (int)(Math.random()*10000);
        payload = booty;      //Set SpaceShip Payload, used for changing ships
    }

    //Set Payload
    private void setPayloadandBooty(int booty){
        this.booty = booty;
        payload = booty;
    }

    @Override   //Attributes of ship
    public java.lang.String toString() {
        return  "Class: ☠ Pirate  "  +super.toString() +  "    Coordinates: (" + Coordinate_x + ", "
                + Coordinate_y + ")     Booty: " +booty;
    }
}
