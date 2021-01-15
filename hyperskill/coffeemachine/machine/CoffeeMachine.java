package coffeemachine.machine;

import java.util.Scanner;

public class CoffeeMachine {
    static final int WATER = 200;
    static final int MILK = 50;
    static final int BEANS = 15;

    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;

    public CoffeeMachine() {
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.cups = 9;
        this.money = 550;
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

    public void buy(Coffee coffee) {
        int requiredWater = coffee.getWater();
        int requiredMilk = coffee.getMilk();
        int requiredBeans = coffee.getBeans();

        if (this.water > requiredWater && this.milk > requiredMilk && this.beans > requiredBeans) {
            this.water -= requiredWater;
            this.milk -= requiredMilk;
            this.beans -= requiredBeans;
            this.cups -= 1;
            this.money += coffee.getCost();
        }
    }

    public void fill(int water, int milk, int beans, int cups) {
        this.water += water;
        this.milk += milk;
        this.beans += beans;
        this.cups += cups;
    }
    public int take() {
        int money = this.money;
        this.money = 0;
        return money;
    }

    public void show() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d of water%n", this.water);
        System.out.printf("%d of milk%n", this.milk);
        System.out.printf("%d of coffee beans%n", this.beans);
        System.out.printf("%d of disposable cups%n", this.cups);
        System.out.printf("%d of money%n", this.money);
    }

    public boolean estimate(int cups) {
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

        coffeeMachine.show();
        System.out.printf("%nWrite action (buy, fill, take):%n");
        String action = scanner.next();

        switch (action) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                int input = scanner.nextInt();
                switch (input) {
                    case 1:
                        coffeeMachine.buy(Coffee.ESPRESSO);
                        break;
                    case 2:
                        coffeeMachine.buy(Coffee.LATTE);
                        break;
                    case 3:
                        coffeeMachine.buy(Coffee.CAPPUCCINO);
                        break;
                    default:
                }
                break;
            case "fill":
                System.out.println("Write how many ml of water do you want to add:");
                int water = scanner.nextInt();
                System.out.println("Write how many ml of milk do you want to add:");
                int milk = scanner.nextInt();
                System.out.println("Write how many grams of coffee beans do you want to add:");
                int beans = scanner.nextInt();
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                int cups = scanner.nextInt();
                coffeeMachine.fill(water, milk, beans, cups);
                break;
            case "take":
                System.out.printf("I gave you $%d", coffeeMachine.take());
                break;
            default:
        }

        System.out.println();
        coffeeMachine.show();


    }
}


enum Coffee {
    ESPRESSO  (250, 0, 16, 4),
    LATTE     (350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);

    private final int water;
    private final int milk;
    private final int beans;
    private final int cost;

    Coffee(int water, int milk, int beans, int cost) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cost = cost;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return beans;
    }

    public int getCost() {
        return cost;
    }
}
