import java.util.*;

/**
 * Created by Administrator on 2020/6/15.
 */
public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(12632125));
        System.out.println(isPalindrome(-585));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        while (x > 0) {
            stack.push(x % 10);
            list.add(x % 10);
            x /= 10;
        }
        if (stack.size() != list.size()) {
            return false;
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if(!next.equals(stack.peek()) ) {
                return false;
            }
            stack.pop();
        }
        return true;
    }
}
