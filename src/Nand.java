import java.util.Map;

/**
 * @author Tomer Peisikov <\tomerp1812@gmail.com>
 * ID 209549542
 * @version ass4.
 * @since 2022/04/14.
 */
public class Nand extends BinaryExpression implements Expression {
    /**
     * constructor of Nand.
     *
     * @param ex1 first expression.
     * @param ex2 2nd expression.
     */
    protected Nand(Expression ex1, Expression ex2) {
        super(ex1, ex2);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        //tries to return the expression.evaluate if it gets null catch the exception.
        try {
            return !(getExpression1().evaluate(assignment) && getExpression2().evaluate(assignment));
        } catch (Exception e) {
            System.out.println("Something went wrong with Nand!");
            return null;
        }
    }

    @Override
    public Boolean evaluate() throws Exception {
        //tries to return the expression.evaluate if it gets null catch the exception.
        try {
            return !(getExpression1().evaluate() && getExpression2().evaluate());
        } catch (Exception e) {
            System.out.println("Something went wrong with Nand!");
            return null;
        }
    }

    @Override
    public String toString() {
        //returns (ex1 A ex2).
        return "(" + getExpression1().toString() + " A " + getExpression2().toString() + ")";
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Nand(getExpression1().assign(var, expression), getExpression2().assign(var, expression));
    }

    @Override
    public Expression nandify() {
        //the nandification of A NAND B = A NAND B.
        return new Nand(getExpression1().nandify(), getExpression2().nandify());
    }

    @Override
    public Expression norify() {
        /*the norification of A NAND B =  [ ( A NOR A ) NOR ( B NOR B ) ] NOR
                                          [ ( A NOR A ) NOR ( B NOR B ) ].
         */
        return new Nor(new Nor(new Nor(getExpression1().norify(), getExpression1().norify()),
                new Nor(getExpression2().norify(), getExpression2().norify())),
                new Nor(new Nor(getExpression1().norify(), getExpression1().norify()),
                        new Nor(getExpression2().norify(), getExpression2().norify())));
    }

    @Override
    public Expression simplify() {
        //the expression 1 A x = ~(x).
        if (getExpression1().simplify().toString().equals("T")) {
            return new Not(getExpression2()).simplify();
        }
        //the expressions x A 1 = ~(x), x A x = ~(x).
        if ((getExpression2().simplify().toString().equals("T"))
                || (getExpression1().simplify().toString().equals(getExpression2().simplify().toString()))) {
            return new Not(getExpression1()).simplify();
        }
        //the expression x A 0 = 1.
        if (getExpression1().simplify().toString().equals("F") || getExpression2().simplify().toString().equals("F")) {
            return new Val(true).simplify();
        }
        return new Nand(getExpression1().simplify(), getExpression2().simplify());
    }
}
