package models;

public class Service extends  Saleable{
    private final Customer servant;
    public Service(String name, int price, Customer servant){
        super(name, price);
        this.servant = servant;
    }

    public Customer getServant() {
        return servant;
    }
    @Override
    public String toString(){
        return super.toString() +"| servant: " + this.getServant();
    }
}
