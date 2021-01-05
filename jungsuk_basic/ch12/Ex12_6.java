package ch12;

class Ex12_6 {
    public static void main(String[] args) {
        for(Direction d: Direction.values())
            System.out.printf("%s=%d%n",d.name(),d.getValue());

        Direction d1 = Direction.EAST;
        Direction d2 = Direction.of(1);

        System.out.printf("d1=%s, %d%n", d1.name(),d1.getValue());
        System.out.printf("d2=%s, %d%n", d2.name(),d2.getValue());
        System.out.println(Direction.EAST.rotate(1));
        System.out.println(Direction.EAST.rotate(2));
        System.out.println(Direction.EAST.rotate(-1));
        System.out.println(Direction.EAST.rotate(-2));
    }
}

