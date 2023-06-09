class Solution{
public int strStr(String haystack, String needle) {
    if (needle.length() == 0) {
        return 0;
    }
    int hLength = haystack.length();
    int nLength = needle.length();
    for (int i = 0; i <= hLength - nLength; i++) {
        if (haystack.substring(i, i + nLength).equals(needle)) {
            return i;
        }
    }
    return -1;
}
}