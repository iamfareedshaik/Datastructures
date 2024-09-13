class House{
    private String foundation;
    private String structre;
    private String roof;

    public House setFoundation(String foundation){
        this.foundation = foundation;
        return this;
    }

    public House setStructure(String structre){
        this.structre = structre;
        return this;
    }

    public House setRoof(String roof){
        this.roof = roof;
        return this;
    }
    public void print(){
        System.out.print(foundation + "" +structre + "" + roof);
    }
}

class Builder{
    public static void main(String args[]){
        House house = new House();
        house.setFoundation("abc").setRoof("gfg");
        house.print();
    }
}