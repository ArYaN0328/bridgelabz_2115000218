import java.util.regex.*;

public class IPAddressValidator {
    public static boolean isValidIPv4(String ip) {
        String regex = "\\b((25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\b";
        return Pattern.matches(regex, ip);
    }

    public static void main(String[] args) {
        String[] testIPs = { "192.168.1.1", "255.255.255.255", "256.100.50.25", "192.168.1.999" };

        for (String ip : testIPs) {
            System.out.println(ip + " → " + isValidIPv4(ip));
        }
    }
}
