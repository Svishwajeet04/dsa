package dp;

public class LcsPrint {

    public static void main(String[] args) {
        String x = "abcdafg";
        String y = "jjjjjj";
        String res = getLcs(x, y, x.length(), y.length(), "");
        System.out.println(res);
    }

    private static String getLcs(String x, String y, int xl, int yl, String res) {
        if(xl == 0 || yl == 0){
            return "";
        }else{
            if(x.charAt(xl -1) == y.charAt(yl - 1)){
                return getLcs(x, y, xl -1 , yl -1, res) +  x.charAt(xl-1) + res;
            }else{
                String res1 = getLcs(x, y, xl -1 , yl, res);
                String res2 = getLcs(x, y, xl, yl - 1, res);
                if(res1.length() > res2.length()){
                    return res1 + res;
                }else{
                    return res2 + res;
                }
            }
        }
    }
}
