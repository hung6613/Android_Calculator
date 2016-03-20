package expression;


/**
 * Created by Tri dep trai on 20/3/2016.
 */
public class Expression {
    String expression;
    double value;
    Expression(){
        expression="";
    }
    Expression(String expression){
        this.expression=expression;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void solve(){
        Infix expression_infix = new Infix(expression);
        Postfix expression_postfix = new Postfix(expression_infix.toPostfix());
        value = expression_postfix.toValue();
    }
}
