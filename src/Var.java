import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Tomer Peisikov <\tomerp1812@gmail.com>
 * ID 209549542
 * @version ass4.
 * @since 2022/04/14.
 */
public class Var implements Expression {
    private String var;

    /**
     * constructor of Var.
     *
     * @param v a string which represents a variable.
     */
    public Var(String v) {
        setVar(v);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        //returns null if the var is not in the map, else returns the value of the key.
        return assignment.get(this.var);
    }

    @Override
    public Boolean evaluate() throws Exception {
        //if we got into here we know we cannot evaluate the expression.
        return null;
    }

    @Override
    public List<String> getVariables() {
        List<String> string = new ArrayList<>();
        string.add(this.var);
        return string;
    }

    @Override
    public String toString() {
        return this.var;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        //if the var is equal to the string var.
        if (this.var.equals(var)) {
            return expression;
        }
        return this;
    }

    @Override
    public Expression nandify() {
        return this;
    }

    @Override
    public Expression norify() {
        return this;
    }

    @Override
    public Expression simplify() {
        return this;
    }

    /**
     * getter of var.
     *
     * @return a string.
     */
    public String getVar() {
        return this.var;
    }

    /**
     * setter of var.
     *
     * @param var a string.
     */
    public void setVar(String var) {
        this.var = var;
    }
}
