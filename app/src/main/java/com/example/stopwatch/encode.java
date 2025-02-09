package com.example.stopwatch;

public class encode {

    public static String encode(String s) {
        String initializer = "11111111";
        int ct = 0;
        int[] a = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            a[i] = (int) s.charAt(i);
            ct++;
        }
        String res = "";
        for (int ii = 0; ii < ct; ii++) {
            int temp = a[ii];
            int[] bin = new int[8]; // Binary representation for one byte (max 8 bits)
            int idx = 0;

            // Convert to binary
            while (temp > 0) {
                bin[idx++] = temp % 2;
                temp = temp / 2;
            }

            // Construct binary string in reverse
            StringBuilder dig = new StringBuilder();
            for (int j = 0; j < idx; j++) {
                dig.append(bin[j]);
            }

            // Reverse the binary string for correct order
            String rev = dig.reverse().toString();

            // Pad binary string to 7 bits (if needed) for standard ASCII
            while (rev.length() < 7) {
                rev = "0" + rev;
            }

            // Append to the result
            res = res.concat(rev);
        }

        // Concatenate initializer and result
        res = initializer.concat(res);
        return res;
    }
}
