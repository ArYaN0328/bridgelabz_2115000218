
import java.util.regex.*;

public class IPAddressValidator {
    private static final String IP_REGEX =
        "^(25[0-5]|2[0-4][0-9]|1?[0-9]?[0-9])\\." +
        "(25[0-5]|2[0-4][0-9]|1?[0-9]?[0-9])\\." +
        "(25[0-5]|2[0-4][0-9]|1?[0-9]?[0-9])\\." +
        "(25[0-5]|2[0-4][0-9]|1?[0-9]?[0-9])$";

    public static boolean isValidIPv4(String ip) {
        return Pattern.matches(IP_REGEX, ip);
    }

    public static void main(String[] args) {
        String[] testIPs = {"192.168.1.1", "255.255.255.255", "256.100.50.25", "192.168.01.1"};
        
        for (String ip : testIPs) {
            System.out.println(ip + " → " + (isValidIPv4(ip) ? "Valid" : "Invalid"));
        }
    }
}

