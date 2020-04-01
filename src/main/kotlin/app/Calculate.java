package app;

import java.util.Stack;

public class Calculate {
    private boolean isOperator(String s)
    {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private double calculate(String result) {
        result = result.trim();
        Stack<Double> values = new Stack<>(); //stos
        String[] tokens = result.split(" +");
        double answer = 0.0;

        for (String token: tokens)
        {
            if(!isOperator(token))
            {
                values.add(Double.parseDouble(token));
            }
            else
            {
                double a = values.pop();
                double b = values.pop();
                switch(token)
                {
                    case "+":
                        answer = a + b;
                        break;
                    case "-":
                        answer = b - a;
                        break;
                    case "*":
                        answer = a * b;
                        break;
                    case "/":
                        answer = a / b;
                        break;
                }
                values.add(answer);
            }
        }
        return answer;
    }
}
