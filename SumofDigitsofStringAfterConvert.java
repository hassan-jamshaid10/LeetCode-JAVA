import java.math.BigInteger;

class Solution {
    public int getLucky(String s, int k) {
      
        StringBuilder numberStr = new StringBuilder();
        for (char c : s.toCharArray()) {
            int value = c - 'a' + 1;  
            numberStr.append(value);  
        }
        BigInteger num = new BigInteger(numberStr.toString());
       
        for (int i = 0; i < k; i++) {
            num = sumOfDigits(num);
        }

        return num.intValue();  
    }

    private BigInteger sumOfDigits(BigInteger num) {
        BigInteger sum = BigInteger.ZERO;
        while (num.compareTo(BigInteger.ZERO) > 0) {
            sum = sum.add(num.mod(BigInteger.TEN));
            num = num.divide(BigInteger.TEN);
        }
        return sum;
    }
}
