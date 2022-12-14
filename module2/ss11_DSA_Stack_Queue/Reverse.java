import java.util.Stack;

public class Reverse {
    public static void main(String[] args) {
        Stack<Integer> arrayStack = new Stack<>();
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);
        Stack<Integer> temp = new Stack<>();
        for (int i = arrayStack.size(); i > 0; i--) {
            temp.push(arrayStack.pop());
        }
        arrayStack = temp;
        System.out.println(arrayStack);
        Stack<String> strings = new Stack<>();
        strings.push("code");
        strings.push("gym");
        Stack<String> tempString = new Stack<>();
        for (int i = strings.size(); i > 0; i--) {
            tempString.push(strings.pop());
        }
        strings = tempString;
        System.out.println(strings);
    }
}
