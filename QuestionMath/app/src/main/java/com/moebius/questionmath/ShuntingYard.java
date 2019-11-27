package com.moebius.questionmath;
import java.util.*;
public class ShuntingYard {

    private enum Operator {
        ADD(1), SUBTRACT(2), MULTIPLY(3), DIVIDE(4);
        final int precedence;
        Operator(int p) {
            precedence = p;
        }
    }

    private Map<String, Operator> operatorMap = new HashMap<String, Operator>() {{
        put("+", Operator.ADD);
        put("-", Operator.SUBTRACT);
        put("*", Operator.MULTIPLY);
        put("/", Operator.DIVIDE);
    }};

    private boolean isHigherPrec(String op, String sub) {
        return (operatorMap.containsKey(sub) &&
                operatorMap.get(sub).precedence >= operatorMap.get(op).precedence);
    }

    public String shuntingYard(String infix) {
        StringBuilder output = new StringBuilder();
        Stack<String> stack = new Stack<String>();

        for (String token : infix.split("")) {
            //operator
            if (operatorMap.containsKey(token)) {
                while ( ! stack.isEmpty() && isHigherPrec(token, stack.peek())) {
                    output.append(stack.pop()).append(' ');
                }
                stack.push(token);
            }
            //parentesis izquierdo
            else if (token.equals("(")) {
                stack.push(token);
            }
            //parentesis derecho
            else if (token.equals(")")) {
                while ( ! stack.peek().equals("(")) {
                    output.append(stack.pop()).append(' ');
                }
                stack.pop();
            }
            //digitos
            else {
                output.append(token).append(' ');
            }
        }

        while ( ! stack.isEmpty()) {
            output.append(stack.pop()).append(' ');
        }

        return output.toString();
    }

    static String evaluatePostfix(String exp)
    {
        //crear pila
        Stack<Integer> stack=new Stack<>();

        // lexer
        for(int i=0;i<exp.length();i++)
        {
            char c=exp.charAt(i);


            if(Character.isDigit(c))
                stack.push(c - '0');

                //  If the scanned character is an operator, pop two
                // elements from stack apply the operator
            else
            {
                int val1 = stack.pop();
                int val2 = stack.pop();
                switch(c)
                {
                    case '+':
                        stack.push(val2+val1);
                        break;

                    case '-':
                        stack.push(val2- val1);
                        break;

                    case '/':
                        stack.push(val2/val1);
                        break;

                    case '*':
                        stack.push(val2*val1);
                        break;
                    case '^':
                        stack.push((int)Math.pow(val2,val1));
                        break;
                    default :
                        return "Error de Sintaxis";

                }
            }
        }
        return Integer.toString(stack.pop());
    }
}

