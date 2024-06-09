import java.util.ArrayList;
import java.util.List;

/**
 * @author Tomer Peisikov <\tomerp1812@gmail.com>
 * ID 209549542
 * @version ass4.
 * @since 2022/04/14.
 */
public abstract class BinaryExpression extends BaseExpression implements Expression {
    private Expression expression1;
    private Expression expression2;

    /**
     * constructor of all binary expressions.
     *
     * @param ex1 first expression.
     * @param ex2 2nd expression.
     */
    protected BinaryExpression(Expression ex1, Expression ex2) {
        setExpression1(ex1);
        setExpression2(ex2);
    }

    @Override
    public List<String> getVariables() {
        List<String> list = new ArrayList<>();
        if (this.expression1.getVariables() != null) {
            //adds all the variables from expression1 to the list.
            list.addAll(this.expression1.getVariables());
        }
        if (this.expression2.getVariables() != null) {
            //adds all the variables from expression2 to the list.
            list.addAll(this.expression2.getVariables());
        }
        return removeDuplicates(list);
    }

    /**
     * the function remove duplicates from the list of the variables.
     *
     * @param list the list.
     * @return the list without duplicates.
     */
    private List<String> removeDuplicates(List<String> list) {
        //makes new list.
        List<String> tmp = new ArrayList<>();
        for (String string : list) {
            //if the tmp does not contain the string add it. which prevents duplications.
            if (!tmp.contains(string)) {
                tmp.add(string);
            }
        }
        return tmp;
    }

    /**
     * setter of expression1.
     *
     * @param expression1 an expression.
     */
    protected void setExpression1(Expression expression1) {
        this.expression1 = expression1;
    }

    /**
     * getter of Expression1.
     *
     * @return an Expression.
     */
    protected Expression getExpression1() {
        return this.expression1;
    }

    /**
     * setter of expression2.
     *
     * @param expression2 an expression.
     */
    protected void setExpression2(Expression expression2) {
        this.expression2 = expression2;
    }

    /**
     * getter of Expression2.
     *
     * @return an Expression.
     */
    protected Expression getExpression2() {
        return this.expression2;
    }
}
