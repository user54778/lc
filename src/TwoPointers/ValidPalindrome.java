package TwoPointers;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String lowerCase = s.toLowerCase();

        int left = 0;
        int right = lowerCase.length() - 1;

        while (left < right) {
            // continue looping if not a letter or digit
            if (!Character.isLetterOrDigit(lowerCase.charAt(left))) {
                left++;
                continue;
            }

            // continue looping if not a letter of digit
            if (!Character.isLetterOrDigit(lowerCase.charAt(right))) {
                right--;
                continue;
            }

            if (lowerCase.charAt(left) != lowerCase.charAt(right)) {
                return false;
            }

            left++; // increment pointers
            right--;
        }

        return true;
    }
}
