interface Chair{
    void siton();
}

interface Sofa{
    void lieon();
}

class VictorianChair implements Chair{
    public void siton(){
        System.out.print("Sitting on Victorian Chair");
    }
}

class VictorianSofa implements Sofa{
    public void lieon(){
        System.out.print("Lying on Sofa");
    }
}

class ModerChair implements Chair{
    public void siton(){
        System.out.print("Sittingon Moder Chair");
    }
}

class ModerSofa implements Sofa{
    public void lieon(){
        System.out.print("Lieon Modern Sofa");
    }
}

interface FurnitreFactory{
    Chair createChair();
    Sofa createSofa();
}

class Victoria implements FurnitreFactory{
    public Chair createChair(){
        return new VictorianChair();
    }

    public Sofa createSofa(){
        return new VictorianSofa();
    }
}

public class AbstractFactory{
    public static void main(String args[]){
        FurnitreFactory factory = new Victoria();
        Chair victorira = factory.createChair();
        Sofa victoriran = factory.createSofa();
        victorira.siton();
        victoriran.lieon();
    }
}