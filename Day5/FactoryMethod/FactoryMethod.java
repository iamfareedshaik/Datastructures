interface Transport{
    void deliver();
}

class Truck implements Transport{
    public void deliver(){
        System.out.print("truck on road delivered");
    }
}

class Ship implements Transport{
    public void deliver(){
        System.out.print("Ship on water delivered");
    }
}

abstract class Logistics{
    public abstract Transport createLogistics();
    
    public void planDeliver(){
        Transport transport = createLogistics();
        transport.deliver();
    }
}

class RoadLogistics extends Logistics{
    public Transport createLogistics(){
        return new Truck();
    }
}

class ShipLogistics extends Logistics{
    public Transport createLogistics(){
        return new Ship();
    }
}


class FactoryMethod{
    public static void main(String args[]){
        ShipLogistics ship = new ShipLogistics();
        ship.planDeliver();
    }
}