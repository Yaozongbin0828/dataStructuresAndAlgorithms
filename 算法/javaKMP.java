// 这段代码实现了KMP算法的关键部分。在kmpSearch方法中，我们使用了computeLPSArray方法来计算模式字符串的最长前缀后缀匹配数组（LPS数组），然后利用LPS数组进行模式匹配。在computeLPSArray方法中，我们计算了给定模式字符串的最长前缀后缀匹配数组。//
// 通过这段代码，您可以在Java中实现KMP算法，并用于在文本中查找指定模式的位置。
public class KMP {
    public static void main(String[] args) {
        String text = "ababcababcabcabc";
        String pattern = "ababcabc";
        int index = kmpSearch(text, pattern);
        if (index == -1) {
            System.out.println("Pattern not found in the text");
        } else {
            System.out.println("Pattern found at index: " + index);
        }
    }

    public static int kmpSearch(String text, String pattern) {
        int[] lps = computeLPSArray(pattern);
        int i = 0;  // 索引指向text
        int j = 0;  // 索引指向pattern
        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == pattern.length()) {
                return i - j;
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    public static int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0;  // 前缀匹配的长度
        int i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
