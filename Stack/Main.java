import java.util.*;

class Stack {
  private static int ptr, count;
  private static int stack[];
  Stack(int size) {
    stack = new int[size];
    count = size;
    ptr = -1;
  }

  static void push(int item) {
    if (ptr == count-1) {
      System.out.println("Stack is Full");
    }
    else {
      ptr++;
      stack[ptr] = item;
      System.out.println(item + " pushed to the stack");
    }
  }

  static int pop(){
    if (ptr == -1) {
      System.out.println("Stack is Empty");
      return -1;
    }
    else {
      System.out.println(stack[ptr] + " popped out from the stack");
      int num = stack[ptr];
      ptr -= 1;
      return num;
    }
  }

  static void Display() {
    for (int i=ptr; i>=0; i--) 
      System.out.print(stack[i] + " ");
  }
}

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the problem: ");
    String prob = sc.nextLine();
    char[] arr = new char[prob.length()];
    for(int i=0; i<prob.length(); i++) {
      arr[i] = prob.charAt(i);
    }
    Stack st = new Stack(prob.length());
    for (int i=0; i<prob.length(); i++) {
      if (arr[i]>47 && arr[i]<58) {
        int a = arr[i] - '0';
        st.push(a);
      }
      else if(arr[i] == '+') {
        int num1 = st.pop();
        int num2 = st.pop();
        int sum = num1 + num2;
        st.push(sum);
      }
      else if(arr[i] == '-') {
        int num1 = st.pop();
        int num2 = st.pop();
        int sum = num1 - num2;
        st.push(sum);
      }
      else if(arr[i] == '*') {
        int num1 = st.pop();
        int num2 = st.pop();
        int sum = num1 * num2;
        st.push(sum);
      }
      else if(arr[i] == '/') {
        int num1 = st.pop();
        int num2 = st.pop();
        int sum = num1 / num2;
        st.push(sum);
      }
      else {
        System.out.println("Error!");
        break;
      }
    }
  }
}