/**
 * @author Tomer Peisikov <\tomerp1812@gmail.com>
 * ID 209549542
 * @version ass4.
 * @since 2022/04/14.
 */
public abstract class UnaryExpression extends BaseExpression implements Expression {
    private Expression expression;

    protected UnaryExpression(Expression ex) {
        setExpression(ex);
    }

    /**
     * setter of expression.
     *
     * @param expression an expression.
     */
    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    /**
     * getter of expression.
     *
     * @return an expression.
     */
    public Expression getExpression() {
        return expression;
    }
}
