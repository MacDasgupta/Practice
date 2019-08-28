package DailyCodingProblem;

import java.math.BigDecimal;

public class MonteCarloPi {
    public static void main(String[] args) {
        int num=100000000;
        double distance = 0;
        int hitPot = 0;
        for(int i=0;i<num;i++){
            double x = 2*Math.random();
            double y = 2*Math.random();
            distance = Math.sqrt(Math.pow(x-1,2)+Math.pow(y-1,2));
            if(distance<1)
                hitPot++;

        }
        BigDecimal b = new BigDecimal(hitPot).divide(new BigDecimal(num),8,BigDecimal.ROUND_DOWN).multiply(new BigDecimal(4));
        double PI = b.doubleValue();
        System.out.println( "hitPot = " +hitPot + "  PI = " + PI);
    }
}
