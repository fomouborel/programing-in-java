class Scratch {
    interface Movable {
        void goTo(double x, double y);
    }

    private static <T extends Movable> void moveAll(T[] elems, double x, double y) {
        for (var e : elems) {
            e.goTo(x, y);
        }
    }
  

    public static void main(String[] args) {
        System.out.println("demo...");
        
    }
}