package ch12;

class Fruit implements Eatable{
    public String toString() {
        return "Fruit";
    }
}
class Apple extends Fruit { public String toString() {return "Apple";}}
class Grape extends Fruit { public String toString() {return "Grape";}}
class Toy                 { public String toString() {return "Toy";}}

interface Eatable{}

class Juice {
    String name;
    Juice(String name) {this.name = name+"Juice";}
    public String toString() {return name;}
}

class Juicer {
    static Juice makeJuice(FruitBox<? extends Fruit> box) {
        String tmp = "";

        for(Fruit f : box.getList()) {
            tmp += f+" ";
        }
        return new Juice(tmp);
    }
}