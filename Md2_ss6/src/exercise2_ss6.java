public class exercise2_ss6 {
    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer("Hello, World!");

        sb.append(" Welcome to Java.");
        System.out.println("After append: " + sb);

        sb.insert(7, "beautiful ");
        System.out.println("After insert: " + sb);

        sb.replace(13, 22, "Java Programming");
        System.out.println("After replace: " + sb);

        sb.delete(13, 31);
        System.out.println("After delete: " + sb);

        System.out.println("Length of StringBuffer: " + sb.length());

        sb.reverse();
        System.out.println("After reverse: " + sb);
    }
}

