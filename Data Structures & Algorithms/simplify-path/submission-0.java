class Solution {
    public String simplifyPath(String path) {
        // Use a Deque as a stack to keep track of directory names
        Deque<String> stack = new ArrayDeque<>();
        
        // Split the path by one or more slashes
        String[] components = path.split("/");
        
        for (String component : components) {

            System.out.println(component);

            // Case 1: Skip empty strings (caused by consecutive slashes "//") or "." (current directory)
            if (component.isEmpty() || component.equals(".")) {
                continue;
            }
            
            // Case 2: If "..", go back to the parent directory by popping the stack
            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollLast(); // Removes the top directory
                }
            } 
            // Case 3: It is a valid directory name, push it onto the stack
            else {
                stack.offerLast(component);
            }
        }
        
        // Build the simplified path from the elements remaining in the stack
        return "/" + String.join("/", stack);
    }
}