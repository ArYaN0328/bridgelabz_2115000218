
import java.util.regex.*;

public class IPAddressValidator {
    public static boolean isValidIPv4(String ip) {
        String regex = "\\b((25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] testIPs = {
            "192.168.1.1",   //  Valid
            "255.255.255.255", //  Valid
            "256.100.50.25",  //  Invalid (256 out of range)
            "192.168.1",      // Invalid (missing last octet)
            "192.168.1.999"   //  Invalid (999 out of range)
        };

        for (String ip : testIPs) {
            System.out.println(ip + " is " + (isValidIPv4(ip) ? "Valid" : "Invalid"));
        }
    }
}

