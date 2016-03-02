import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * Created by matthewhartman on 3/1/16.
 */
public class Combo {
    public static void main(String[] args) throws Exception {

        BigDecimal sub, total;

        //Validate
        if (args.length != 2) {
            throw new Exception("Need two arguments!");
        }
        try {
            sub = new BigDecimal(args[0]);
            total = new BigDecimal(args[1]);
            if (sub.compareTo(BigDecimal.ZERO) < 0 || total.compareTo(BigDecimal.ZERO) < 0) {
                throw new Exception("Need positive arguments!");
            }
            if (sub.compareTo(total) > 0) {
                throw new Exception("args[0] must be a sub total of args[1]!");
            }
        } catch (NumberFormatException e) {
            throw new Exception("Need numerical arguments!");
        }

        //Calculate
        BigDecimal result;
        try {
            BigDecimal x = factorial(sub);
            BigDecimal y = factorial(total);
            BigDecimal z = factorial(total.subtract(sub));

            result = y.divide(x.multiply(z), BigDecimal.ROUND_HALF_UP);
        } catch (Throwable t) {
            t.printStackTrace();
            throw t;
        }
        System.out.println("result = " + NumberFormat.getIntegerInstance().format(result));
    }

    static BigDecimal factorial(BigDecimal bd) {
        if (bd.compareTo(BigDecimal.ZERO) == 0) return new BigDecimal("1");
        return bd.multiply(factorial(bd.subtract(new BigDecimal("1"))));
    }
}
