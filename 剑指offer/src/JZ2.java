// 替换空格
public class JZ2 {

    public static void main(String[] args) {
        String s = "We Are Happy";
        System.out.println(s.replaceAll(" ","%20"));
    }
    /**
     * @param s string字符串
     * @return string字符串
     */
    public String replaceSpace (String s) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c==' '){
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
