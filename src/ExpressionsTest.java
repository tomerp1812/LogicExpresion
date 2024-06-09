import java.util.Map;
import java.util.TreeMap;

/**
 * @author Tomer Peisikov <\tomerp1812@gmail.com>
 * ID 209549542
 * @version ass4.
 * @since 2022/04/14.
 */
public class ExpressionsTest {
    /**
     * @param args unused.
     */
    public static void main(String[] args) throws Exception {
        Expression expression = new Or(new Nand(new Xor(new Not(new Var("x")),
                new Var("y")), new Var("z")), new Val(true));
        Map<String, Boolean> assignment = new TreeMap<>();
        assignment.put("x", true);
        assignment.put("y", false);
        assignment.put("z", true);
        System.out.println(expression);
        System.out.println(expression.evaluate(assignment));
        System.out.println(expression.nandify());
        System.out.println(expression.norify());
        System.out.println(expression.simplify());
    }
}