public class Test {


    public static void main(String[] args) {
        String s ="101010_1.0001.100\t10\t10\t10\t1\t1\t100";
        String [] array =s.split("\t");
        System.out.println(array.length);
        for (String g:array) {
            System.out.println(g);
        }
    }
}
