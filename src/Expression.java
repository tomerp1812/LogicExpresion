import java.util.List;
import java.util.Map;

/**
 * @author Tomer Peisikov <\tomerp1812@gmail.com>
 * ID 209549542
 * @version ass4.
 * @since 2022/04/14.
 */
public interface Expression {

    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result. If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     *
     * @param assignment a map of string,boolean.
     * @return true or false.
     * @throws Exception If the expression contains a variable which is not in the assignment.
     */
    Boolean evaluate(Map<String, Boolean> assignment) throws Exception;


    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     *
     * @return true or false.
     * @throws Exception If the expression contains a variable which is not in the assignment.
     */
    Boolean evaluate() throws Exception;


    /**
     * getter of variables.
     *
     * @return Returns a list of the variables in the expression.
     */
    List<String> getVariables();

    /**
     * converts an expression to a string.
     *
     * @return a nice string representation of the expression.
     */
    String toString();

    /**
     * assigns an expression to a var.
     *
     * @param var        var are replaced with the provided expression (Does not modify the current expression).
     * @param expression the expression.
     * @return a new expression in which all occurrences of the variable.
     */
    Expression assign(String var, Expression expression);

    /**
     * converts the expression to an equal expression with only Nand operations.
     *
     * @return the expression tree resulting from converting all the operations to the logical Nand operation.
     */
    Expression nandify();


    /**
     * converts the expression to an equal expression with only Nor operations.
     *
     * @return the expression tree resulting from converting all the operations to the logical Nor operation.
     */
    Expression norify();

    /**
     * simplifies the expression as much as possible.
     *
     * @return a simplified version of the current expression.
     */
    Expression simplify();
}