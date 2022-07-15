class Solution {
    
    public static String addStrings(String num1, String num2) {
        int carry = 0;
        String result = "";

        if (num1.length() < num2.length()) {
            int j = num2.length() - 1;
            for (int i = num1.length() - 1; i >= 0; i--, j--) {
                int x1 = num1.charAt(i) - '0';
                int x2 = num2.charAt(j) - '0';
                int sum = x1 + x2 + carry;
                //It is two integers
                if (sum >= 10 && sum <= 99) {
                    result = sum % 10 + result;
                    carry = Integer.parseInt(Integer.toString(sum).substring(0, 1));
                } else {
                    result = sum + result;
                    carry = 0;
                }

            }
            int startIndex = num2.length() - num1.length() - 1;
            while (startIndex >= 0) {
                int x = num2.charAt(startIndex) - '0';
                x = x + carry;
                if (x >= 10 && x <= 99) {
                    result = x % 10 + result;
                    carry = Integer.parseInt(Integer.toString(x).substring(0, 1));
                } else {
                    result = x + result;
                    carry = 0;
                }

                startIndex--;
            }
            if (carry != 0) result = carry + result;


        } else {
            int j = num1.length() - 1;
            for (int i = num2.length() - 1; i >= 0; i--, j--) {
                int x1 = num1.charAt(j) - '0';
                int x2 = num2.charAt(i) - '0';
                int sum = x1 + x2 + carry;
                //It is two integers
                if (sum >= 10 && sum <= 99) {
                    result = sum % 10 + result;
                    carry = Integer.parseInt(Integer.toString(sum).substring(0, 1));
                } else {
                    result = sum + result;
                    carry = 0;
                }

            }
            int startIndex = num1.length() - num2.length() - 1;
            while (startIndex >= 0) {
                int x = num1.charAt(startIndex) - '0';
                x = x + carry;
                if (x >= 10 && x <= 99) {
                    result = x % 10 + result;
                    carry = Integer.parseInt(Integer.toString(x).substring(0, 1));
                } else {
                    result = x + result;
                    carry = 0;
                }

                startIndex--;
            }
            if (carry != 0) result = carry + result;


        }
        return result;

    }

}
