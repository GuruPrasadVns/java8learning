package com.ds.stack;

import java.util.Stack;

public class StackOperations {

    public static String infixToPostfix(String exp){
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < exp.length(); i++){
            char c = exp.charAt(i);

            if(Character.isLetterOrDigit(c)){
                sb.append(c);
            }
            else if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            else if(c == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.pop();
            }
            else if(c == ']'){
                while(!stack.isEmpty() && stack.peek() != '['){
                    sb.append(stack.pop());
                }
                stack.pop();
            }
            else if(c == '}'){
                while(!stack.isEmpty() && stack.peek() != '{'){
                    sb.append(stack.pop());
                }
                stack.pop();
            }
            else {
                while(!stack.isEmpty() && (precedance(stack.peek()) >= precedance(c) || (precedance(c) == precedance(stack.peek()) && assoicativity(c) == 'L' ))){
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static char assoicativity(char c) {
        if(c == '^')
            return 'R';
        return 'L';
    }

    public static int precedance(char operator){
        switch(operator){
            case '^' : return 2;
            case '*' : return 1;
            case '/' : return 1;
            case '+' : return 0;
            case '-' : return 0;
        }
        return -1;
    }

    public static String prefixToInfix(String exp){
        Stack<StringBuilder> stack = new Stack<>();

        for(int i = exp.length() - 1; i >=0 ; i--){
                char c = exp.charAt(i);
                if(Character.isLetterOrDigit(c)){
                    StringBuilder sb = new StringBuilder();
                    sb.append(c);
                    stack.push(sb);
                }else{
                    StringBuilder sb = new StringBuilder();
                    sb.append("(").append(stack.pop()).append(c).append(stack.pop()).append(")");
                    stack.push(sb);
                }
        }

        return stack.pop().toString();
    }

    public static String prefixToPostfix(String exp){
        Stack<StringBuilder> stack = new Stack<>();

        for(int i = exp.length() - 1; i >=0 ; i--){
            char c = exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                stack.push(sb);
            }else{
                StringBuilder sb = new StringBuilder();
                sb.append(stack.pop()).append(stack.pop()).append(c);
                stack.push(sb);
            }
        }

        return stack.pop().toString();
    }

    public static String postfixToPrefix(String exp){
        Stack<StringBuilder> stack = new Stack<>();

        for(int i = 0; i < exp.length() ; i++){
            char c = exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                stack.push(sb);
            }else{
                StringBuilder sb = new StringBuilder();
                String operand1 = stack.pop().toString();
                String operand2 = stack.pop().toString();
                sb.append(c).append(operand2).append(operand1);
                stack.push(sb);
            }
        }

        return stack.pop().toString();
    }

    public static String postfixToInfix(String exp){
        Stack<StringBuilder> stack = new Stack<>();

        for(int i = 0; i < exp.length() ; i++){
            char c = exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                stack.push(sb);
            }else{
                StringBuilder sb = new StringBuilder();
                String operand1 = stack.pop().toString();
                String operand2 = stack.pop().toString();
                sb.append("(").append(operand2).append(c).append(operand1).append(")");
                stack.push(sb);
            }
        }

        return stack.pop().toString();
    }

    public static boolean isBalanced(String exp){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < exp.length(); i++){
            char currentCharacter = exp.charAt(i);

            if(currentCharacter == '(' || currentCharacter == '[' || currentCharacter == '{')
                stack.push(currentCharacter);
            else if(currentCharacter == ')' || currentCharacter == ']' || currentCharacter == '}'){
                 Character poppedItem = stack.pop();

                 if(currentCharacter == ')' && poppedItem != '(')
                     return false;

                if(currentCharacter == ']' && poppedItem != '[')
                    return false;

                if(currentCharacter == '}' && poppedItem != '{')
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public static int evaluatePostfix(String exp){
        // In expression operators and operand should be separated by space
        String[] expArray = exp.split(" ");
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < expArray.length; i++){
             String currentString = expArray[i];
             if(currentString.equals("+")|| currentString.equals("-") || currentString.equals("/") || currentString.equals("*")){
                 if(currentString.equals("+")){
                     Integer firstOperand = stack.pop();
                     Integer secondOperand = stack.pop();
                     Integer result = secondOperand + firstOperand;
                     stack.push(result);
                 }
                 else if(currentString.equals("-")){
                     Integer firstOperand = stack.pop();
                     Integer secondOperand = stack.pop();
                     Integer result = secondOperand - firstOperand;
                     stack.push(result);
                 }
                 else if(currentString.equals("/")){
                     Integer firstOperand = stack.pop();
                     Integer secondOperand = stack.pop();
                     Integer result = secondOperand / firstOperand;
                     stack.push(result);
                 }
                 else if(currentString.equals("*")){
                     Integer firstOperand = stack.pop();
                     Integer secondOperand = stack.pop();
                     Integer result = secondOperand * firstOperand;
                     stack.push(result);
                 }
             }else{
                 Integer currentValue = Integer.parseInt(currentString);
                 stack.push(currentValue);
             }
        }
        return stack.pop();
    }
}
