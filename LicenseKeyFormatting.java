public class LicenseKeyFormatting {
    
    public String licenseKeyFormatting(String s, int k) {
        s = s.replaceAll("-", "");
        s = s.toUpperCase();
        StringBuilder output = new StringBuilder();
        int rem = s.length() % k;
        int startIndex = 0;
        if(rem != 0) {
            output.append(s.substring(0, rem));
            if(k < s.length()) output.append("-");
            startIndex = rem;
        }
        
        for(int i=startIndex; i < s.length(); i=i+k) {
            output.append(s.substring(i, i+k));
            if(i+k < s.length()) output.append("-");
        }
        return output.toString();
    }
    public static void main(String[] args) throws Exception {
        LicenseKeyFormatting sol = new LicenseKeyFormatting();
        System.out.println(sol.licenseKeyFormatting("2", 2));
    }
}
