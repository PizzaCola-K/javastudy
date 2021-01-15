package coffeemachine.machine;

import java.util.Scanner;

public class CoffeeMachine {
    static final int WATER = 200;
    static final int MILK = 50;
    static final int BEANS = 15;

    private int water;
    private int milk;
    private int beans;

    public CoffeeMachine() {
        this.water = 0;
        this.milk = 0;
        this.beans = 0;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public void setBeans(int beans) {
        this.beans = beans;
    }

    public boolean canMake(int cups) {
        int waterNeed = cups * CoffeeMachine.WATER;
        int milkNeed = cups * CoffeeMachine.MILK;
        int beansNeed = cups * CoffeeMachine.BEANS;

        int count = this.water / CoffeeMachine.WATER;
        if (count > this.milk / CoffeeMachine.MILK) {
            count = this.milk / CoffeeMachine.MILK;
        }
        if (count > this.beans / CoffeeMachine.BEANS) {
            count = this.beans / CoffeeMachine.BEANS;
        }

        if (this.water > waterNeed && this.milk > milkNeed && this.beans > beansNeed) {
            System.out.print("Yes, I can make that amount of coffee");
            if (count > cups) {
                System.out.printf(" (and even %d more than that)", count - cups);
            }
            System.out.println();
            return true;
        } else {
            System.out.printf("No, I can make only %d cup(s) of coffee%n", count);
            return false;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();
        coffeeMachine.setWater(water);
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();
        coffeeMachine.setMilk(milk);
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beans = scanner.nextInt();
        coffeeMachine.setBeans(beans);
        System.out.println("Write how many cups of coffee you will need: ");
        int cups = scanner.nextInt();

        coffeeMachine.canMake(cups);

    }
}
