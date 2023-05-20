public class ProblemSolvingTopic {
	
	 public static String reverseParentheses(String s) {
	        StringBuilder sb = new StringBuilder(s);
	        int start = 0;
	        
	        for (int i = 0; i < sb.length(); i++) {
	            if (sb.charAt(i) == '(') {
	                start = i;
	            } else if (sb.charAt(i) == ')') {
	                StringBuilder reversed = new StringBuilder(sb.substring(start + 1, i)).reverse();
	                sb.replace(start + 1, i, reversed.toString());
	            }
	        }

	        return sb.toString();
	    }

	    public static void main(String[] args) {
	        System.out.println(reverseParentheses("abd(jnb)asdf")); // Output: abd(bnj)asdf
	        System.out.println(reverseParentheses("abdjnbasdf")); // Output: abdjnbasdf
	        System.out.println(reverseParentheses("dd(df)a(ghhh)")); // Output: dd(fd)a(hhhg)
	    }	
}