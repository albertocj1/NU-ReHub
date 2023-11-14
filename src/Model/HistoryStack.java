package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class HistoryStack {

    public static Stack<String> historysearchStack = new Stack<>();

    public void pushToStack(String item) {
        historysearchStack.push(item);
    }

    public Stack<String> getHistoryStack() {
        return historysearchStack;
    }

    public static Object[][] separateStackElements(Stack<String> stack) {
        int stackSize = stack.size();
        Object[][] separatedArray = new Object[stackSize][3];

        // Use a List to temporarily store the popped elements
        List<String> tempElements = new ArrayList<>();

        for (int i = 0; i < stackSize; i++) {
            // Pop elements from the original stack and store them in the List
            tempElements.add(stack.pop());
        }

        // Process elements from the List and push them back to the original stack in reverse order
        for (int i = 0; i < stackSize; i++) {
            String stackElement = tempElements.get(i);
            String[] words = stackElement.split("\\*");

            // Ensure that there are at least two words
            if (words.length >= 3) {
                separatedArray[i][0] = words[0].trim();
                separatedArray[i][1] = words[1].trim();
                separatedArray[i][2] = words[2].trim();
            } else {
                System.out.println("Invalid stack element: " + stackElement);
            }
        }

        // Push the processed elements back to the original stack in reverse order
        for (int i = stackSize - 1; i >= 0; i--) {
            stack.push(tempElements.get(i));
        }

        return separatedArray;
    }
}
