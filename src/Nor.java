import java.util.Map;

/**
 * @author Tomer Peisikov <\tomerp1812@gmail.com>
 * ID 209549542
 * @version ass4.
 * @since 2022/04/14.
 */
public class Nor extends BinaryExpression implements Expression {
    /**
     * constructor of Nor.
     *
     * @param ex1 first expression.
     * @param ex2 2nd expression.
     */
    protected Nor(Expression ex1, Expression ex2) {
        super(ex1, ex2);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        //tries to return the expression.evaluate if it gets null catch the exception.
        try {
            return !(getExpression1().evaluate(assignment) || getExpression2().evaluate(assignment));
        } catch (Exception e) {
            System.out.println("Something went wrong with Nor!");
            return null;
        }
    }

    @Override
    public Boolean evaluate() throws Exception {
        //tries to return the expression.evaluate if it gets null catch the exception.
        try {
            return !(getExpression1().evaluate() || getExpression2().evaluate());
        } catch (Exception e) {
            System.out.println("Something went wrong with Nor!");
            return null;
        }
    }

    @Override
    public String toString() {
        //returns (ex1 V ex2).
        return "(" + getExpression1().toString() + " V " + getExpression2().toString() + ")";
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Nor(getExpression1().assign(var, expression), getExpression2().assign(var, expression));
    }

    @Override
    public Expression nandify() {
        /* the nandification of A NOR B = [ ( A NAND A ) NAND ( B NAND B ) ] NAND
        [ ( A NAND A ) NAND ( B NAND B ) ].
         */
        return new Nand(new Nand(new Nand(getExpression1().nandify(), getExpression1().nandify()),
                new Nand(getExpression2().nandify(), getExpression2().nandify())),
                new Nand(new Nand(getExpression1().nandify(), getExpression1().nandify()),
                        new Nand(getExpression2().nandify(), getExpression2().nandify())));
    }

    @Override
    public Expression norify() {
        //the norification of A NOR B = A NOR B.
        return new Nor(getExpression1().norify(), getExpression2().norify());
    }

    @Override
    public Expression simplify() {
        //the expression x V 1 = 0.
        if (getExpression1().simplify().toString().equals("T") || getExpression2().simplify().toString().equals("T")) {
            return new Val(false).simplify();
        }
        //the expression 0 V x = ~(x).
        if (getExpression1().simplify().toString().equals("F")) {
            return new Not(getExpression2()).simplify();
        }
        //the expression x V 0 = ~(x).
        if (getExpression2().simplify().toString().equals("F")) {
            return new Not(getExpression1()).simplify();
        }
        //the expression x V x = ~(x).
        if (getExpression1().simplify().toString().equals(getExpression2().simplify().toString())) {
            return new Not(getExpression1()).simplify();
        }
        return new Nor(getExpression1().simplify(), getExpression2().simplify());
    }
}
