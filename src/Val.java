import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Tomer Peisikov <\tomerp1812@gmail.com>
 * ID 209549542
 * @version ass4.
 * @since 2022/04/14.
 */
public class Val implements Expression {
    private Boolean bol;

    /**
     * constructor of Val.
     *
     * @param b a boolean expression.
     */
    public Val(Boolean b) {
        setBol(b);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return this.bol;
    }

    @Override
    public Boolean evaluate() throws Exception {
        return this.bol;
    }

    @Override
    public List<String> getVariables() {
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        //if the val is true
        if (this.bol) {
            return "T";
        }
        return "F";
    }

    @Override
    public Expression assign(String var, Expression expression) {
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
     * setter of Bol.
     *
     * @param bol boolean expression.
     */
    public void setBol(Boolean bol) {
        this.bol = bol;
    }

    /**
     * getter of Bol.
     *
     * @return a boolean expression.
     */
    public Boolean getBol() {
        return this.bol;
    }
}
