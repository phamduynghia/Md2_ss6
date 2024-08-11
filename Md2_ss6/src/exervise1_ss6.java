public class exervise1_ss6 {
    public static void main(String[] args) {

        String str = "  Hello, Java World!  ";

        System.out.println("Is the string empty? " + str.isEmpty());

        System.out.println("Trimmed string: '" + str.trim() + "'");

        String str2 = "hello, java world!";
        System.out.println("Equals: " + str.equals(str2));
        System.out.println("EqualsIgnoreCase: " + str.equalsIgnoreCase(str2));

        String[] words = str.split(" ");
        System.out.println("Split string:");
        for (String word : words) {
            System.out.println(word);
        }

        String str3 = " Have a nice day!";
        System.out.println("Concatenated string: " + str.concat(str3));

        System.out.println("Contains 'Java': " + str.contains("Java"));

        System.out.println("Uppercase string: " + str.toUpperCase());

        System.out.println("Lowercase string: " + str.toLowerCase());

        System.out.println("Replaced 'Java' with 'Programming': " + str.replace("Java", "Programming"));

        System.out.println("Length of string: " + str.length());
    }
}
