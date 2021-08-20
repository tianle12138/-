package Easy;

import javax.xml.soap.SAAJMetaFactory;

public class _1736 {
    public static void main(String[] args) {
        _1736 clazz = new _1736();

        String time = "??:3?";
        System.out.println(clazz.maximumTime(time));

    }

    public String maximumTime(String time) {
        char[] chars = time.toCharArray();
        if (chars[0] == '?') {
            chars[0] = (chars[1] <= '9' && chars[1] >= '4') ? '1' : '2';
        }

        if (chars[1] == '?') {
            chars[1] = chars[0] == '2' ? '3' : '9';
        }

        chars[3] = chars[3] == '?' ? '5' : chars[3];
        chars[4] = chars[4] == '?' ? '9' : chars[4];
        return new String(chars);
    }
}
