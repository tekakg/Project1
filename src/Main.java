
interface Pizza
{
    void getflavour();
}
class TomatoPizza implements Pizza {
    public void getflavour() {
        System.out.println("tomato flavour");
    }
}

class OnionPizza implements Pizza{
    public void getflavour(){
        System.out.println("onion flavour");
    }
}

class CornPizza implements Pizza{
    public void getflavour(){
        System.out.println("corn pizza");
    }
}

interface factoryType
{
    Pizza getPizza(String str);
}
class NormalFactory implements factoryType {

    @Override
    public Pizza getPizza(String str) {
        if (str == "TomatoPizza") {
            return new TomatoPizza();
        }
            return new OnionPizza();
    }
}
class SpecialFactory implements factoryType{
    public Pizza getPizza(String str){
            return new CornPizza();

    }
}

class FactoryOfFactory{

    public factoryType getFactory(String str)
    {
        if(str=="NormalFactory"){
            return new NormalFactory();
        }
            return new SpecialFactory();

    }
}

public class Main {
    public static void main(String[] args) {
        FactoryOfFactory factoryselector=new FactoryOfFactory();
        factoryType factoryobject=factoryselector.getFactory("NormalFactory");
        Pizza firstPizza=factoryobject.getPizza("CornPizza");
        firstPizza.getflavour();
    }
}