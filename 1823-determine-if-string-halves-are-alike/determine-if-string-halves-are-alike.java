class Solution {
    public boolean halvesAreAlike(String s) {
        int mid = s.length() / 2;
        int count = 0;

        for (int i = 0; i < mid; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }

        for (int i = mid; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                count--;
            }
        }

        return count == 0;
    }

    private boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
