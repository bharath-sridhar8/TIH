package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EvalReversePolishNotation {

	public int evalRPN(String[] tokens) {
		// iterate from left till we see an operator at index `idx`
		// take the chars from `idx - 1` & `idx - 2` as the operands.
		// perform the operation & replace the operator with the result.
		// replace the operands with some other char, ex: '_' & slide them to the left
		//      this way operands are in place for the next operator.
		// remember about integer division
		// return last char
		Set<String> operators = new HashSet(Arrays.asList("+", "-", "/", "*"));
		for (int i = 0; i < tokens.length; i++) {
			String s = tokens[i];
			if (operators.contains(tokens[i])) {
				int leftOperand = Integer.parseInt(tokens[i-2]);
				int rightOperand = Integer.parseInt(tokens[i-1]);
				int result;
				switch (s) {
					case "+":
						result = leftOperand + rightOperand;
						break;
					case "-":
						result = leftOperand - rightOperand;
						break;
					case "*":
						result = leftOperand * rightOperand;
						break;
					default:
						result = leftOperand / rightOperand;
				}
				tokens[i] = Integer.toString(result);
				tokens[i-1] = "_";
				tokens[i-2] = "_";
				slideUnderscoresLeft(tokens, i-2);
			}
		}
		return Integer.parseInt(tokens[tokens.length - 1]);
	}

	private void slideUnderscoresLeft(String[] tokens, int idx) {
		int left = idx - 1;
		while (left >= 0 && !Objects.equals(tokens[left], "_")) {
			swap(tokens, left, idx + 1);
			idx--;
			left = idx - 1;
		}
	}

	private void swap(String[] tokens, int left, int right) {
		tokens[right] = tokens[left];
		tokens[left] = "_";
	}

	public static void main(String[] args) {
		EvalReversePolishNotation evalReversePolishNotation = new EvalReversePolishNotation();
		System.out.println(evalReversePolishNotation.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
	}

}
