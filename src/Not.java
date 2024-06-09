import java.util.List;
import java.util.Map;

/**
 * @author Tomer Peisikov <\tomerp1812@gmail.com>
 * ID 209549542
 * @version ass4.
 * @since 2022/04/14.
 */
public class Not extends UnaryExpression implements Expression {
    /**
     * constructor of Not.
     *
     * @param ex an expression.
     */
    protected Not(Expression ex) {
        super(ex);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        //tries to return the expression.evaluate if it gets null catch the exception.
        try {
            return !(getExpression().evaluate(assignment));
        } catch (Exception e) {
            System.out.println("Something went wrong with Not!");
            return null;
        }
    }

    @Override
    public Boolean evaluate() throws Exception {
        //tries to return the expression.evaluate if it gets null catch the exception.
        try {
            return !(getExpression().evaluate());
        } catch (Exception e) {
            System.out.println("Something went wrong with Not!");
            return null;
        }
    }

    @Override
    public List<String> getVariables() {
        return getExpression().getVariables();
    }

    @Override
    public String toString() {
        //returns ~(ex).
        return "~(" + getExpression().toString() + ")";
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Not(getExpression().assign(var, expression));
    }

    @Override
    public Expression nandify() {
        //the nandification of not  NOT( A ) = A NAND A.
        return new Nand(getExpression().nandify(), getExpression().nandify());
    }

    @Override
    public Expression norify() {
        //the norification of not(A) = A NOR A.
        return new Nor(getExpression().norify(), getExpression().norify());
    }

    @Override
    public Expression simplify() {
        //the expression ~(1) = 0.
        if (getExpression().simplify().toString().equals("T")) {
            return new Val(false).simplify();
        }
        //the expression ~(0) = 1.
        if (getExpression().simplify().toString().equals("F")) {
            return new Val(true).simplify();
        }
        return new Not(getExpression().simplify());
    }
}
