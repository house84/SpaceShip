
public class CargoShip extends SpaceShip implements CanMove{

    //Variables
    private int cargo;

    //Constructor
    CargoShip(int Date, String designator) {
        setDate(Date);                      //Set Build Date
        setName();                          //Set Name
        Set_Coordinates();                  //Set initial Coordinates (randomly)
        this.designator = designator;       //Set Hull Number
        setCargo();                         //Establish Payload Randomly
        setType();                          //Set type to 2
    }

    //Ship Conversion Constructor
    CargoShip(SpaceShip converted, int designator){
        this.designator = "C"+ designator;                          //Assign new Cargo Hull number
        moveShip(converted.Coordinate_x, converted.Coordinate_y);   //Copy Current Coordinates
        this.date = converted.date;                                 //Copy Original Build Date
        this.name = converted.name;                                 //Copy Original Name
        setPayloadandCargo(converted.payload);                      //Change Booty to Cargo and Set Payload
        setType();                                                  //Change type to 2
    }

    @Override   //Change coordinates of ship
    public void moveShip(int x, int y){
        Coordinate_x = x;
        Coordinate_y = y;
    }

    //Value to identify Type of Ship, Cargo Ship is type 2
    private void setType(){ Type = 2; }

    //Set the Ships initial Coordinates
    private void Set_Coordinates(){
        Coordinate_x = (int)(Math.random()*9);
        Coordinate_y = (int)(Math.random()*9);
    }

    //Set Initial Cargo capacity randomly
    private void setCargo(){
        cargo = (int)(Math.random()*10000);
        payload = cargo;    //Set SpaceShip Payload, used for changing ships
    }

    //Set Payload and Cargo
    private void setPayloadandCargo(int cargo){
        this.cargo = cargo;
        payload = cargo;
    }

    @Override   //Display Ships Attributes
    public java.lang.String toString() {
        return  "Class: ⛿ Cargo   " + super.toString() +  "   Coordinates: (" + Coordinate_x + ", "
                + Coordinate_y + ")     Cargo Load: " + cargo;
    }
}
