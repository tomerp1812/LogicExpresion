import java.util.Map;


/**
 * @author Tomer Peisikov <\tomerp1812@gmail.com>
 * ID 209549542
 * @version ass4.
 * @since 2022/04/14.
 */
public class And extends BinaryExpression implements Expression {
    /**
     * constructor of And.
     *
     * @param ex1 first expression.
     * @param ex2 2nd expression.
     */
    protected And(Expression ex1, Expression ex2) {
        super(ex1, ex2);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        //tries to return the expression.evaluate if it gets null catch the exception.
        try {
            return getExpression1().evaluate(assignment) && getExpression2().evaluate(assignment);
        } catch (Exception e) {
            System.out.println("Something went wrong with And!");
            return null;
        }
    }

    @Override
    public Boolean evaluate() throws Exception {
        //tries to return the expression.evaluate if it gets null catch the exception.
        try {
            return getExpression1().evaluate() && getExpression2().evaluate();
        } catch (Exception e) {
            System.out.println("Something went wrong with And!");
            return null;
        }
    }

    @Override
    public String toString() {
        //returns (ex1 & ex2).
        return "(" + getExpression1().toString() + " & " + getExpression2().toString() + ")";
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new And(getExpression1().assign(var, expression), getExpression2().assign(var, expression));
    }

    @Override
    public Expression nandify() {
        //the nandification of A AND B = ( A NAND B ) NAND ( A NAND B ).
        return new Nand(new Nand(getExpression1().nandify(), getExpression2().nandify()),
                new Nand(getExpression1().nandify(), getExpression2().nandify()));
    }

    @Override
    public Expression norify() {
        //the norification of A AND B = ( A NOR A ) NOR ( B NOR B ).
        return new Nor(new Nor(getExpression1().norify(), getExpression1().norify()),
                new Nor(getExpression2().norify(), getExpression2().norify()));
    }

    @Override
    public Expression simplify() {
        //the expression 1 & x = x.
        if (getExpression1().simplify().toString().equals("T")) {
            return getExpression2().simplify();
        }
        //the expression x & 1 = x.
        if (getExpression2().simplify().toString().equals("T")) {
            return getExpression1().simplify();
        }
        //the expression x & 0 = 0.
        if (getExpression1().simplify().toString().equals("F") || getExpression2().simplify().toString().equals("F")) {
            return new Val(false).simplify();
        }
        //the expression x & x = x.
        if (getExpression1().simplify().toString().equals(getExpression2().simplify().toString())) {
            return getExpression1().simplify();
        }
        return new And(getExpression1().simplify(), getExpression2().simplify());
    }
}
