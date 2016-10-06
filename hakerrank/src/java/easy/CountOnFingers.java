package easy;

/**
 * Oh, how cursed we are to have but 10 digits upon our fingers. Imagine the possibilities were we able to count to numbers beyond! But halt! With 10 digits upon our two appendages, 1024 unique combinations appear! But alas, counting in this manner is cumbersome, and counting to such a number beyond reason. Surely being able to count up to 100 would suffice!
 You will be given inputs which correspond to the 10 digits of a pair of hands in the following format, where 1 means the finger is raised, and 0 means the finger is down.
 0111011100 -> 37
 1010010000 -> Invalid
 0011101110 -> 73
 0000110000 -> 55
 1111110001 -> Invalid
Schema:
 LP	LR	LM	LI	LT	RT	RI	RM	RR	RP
 0	1	1	1	0	1	1	1	0	0

 */
public class CountOnFingers {

    public static void main(String[] args) {
        String input1 = "0111011100";
        String input2 = "1010010000";
        String input3 = "0000110000";
        System.out.println(resolveNumber(input1));
        System.out.println(resolveNumber(input2));
        System.out.println(resolveNumber(input3));

    }

    private static String resolveNumber(String input) {
     if (input.length()>10) return "Invalid input";
     if(checkLeft(input.substring(0,4)) &&  checkRight(input.substring(5))){
         return input+" = "+convertToNum(input);
     }
        return "Invalid input";
    }

    private static int convertToNum(String input) {
        int number = 0;
        for (int i=0; i<4; i++) {
            if (input.charAt(i) == '1') number+=10;
        }
        if (input.charAt(4) == '1') number+=50;
        for (int i=6; i<10; i++) {
            if (input.charAt(i) == '1') number+=1;
        }
        if (input.charAt(5) == '1') number+=5;

        return number;
    }

    private static boolean checkLeft(String left) {
        for (int i=0; i<left.length()-1;i++) {
            if (left.charAt(i)=='1' && left.charAt(i+1) == '0') return false;
        }
        return true;
    }

    private static boolean checkRight(String right) {
        for (int i=1; i<right.length(); i++){
            if (right.charAt(i-1)=='0' && right.charAt(i) == '1') return false;
        }
        return true;
    }
}
