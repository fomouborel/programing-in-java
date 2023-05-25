class Scratch {
    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3};
        String[] strs = {"A", "B", "C"};

        print(ints);
        print(strs);
    }



    public static <T> void print(T[] elems) { // <- complete this line
        for (int i = 0; i < elems.length; i++)
            System.out.print(elems[i] + " ");
        System.out.println();
    }
}