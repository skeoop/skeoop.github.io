public class RecursionPac {
    private static String strRev(String str) {
        if (str.length( )== 0) return ""; // create start of string for the result
        return str.charAt(str.length()-1) + strRev(str.substring(0,str.length()-1));
    }

    private static int fibonacci(int n) {
        if (n<=1) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    private static double power(int x, int y) {
        if (y == 0) return 1;
        return power(x,y-1) * x;
    }

    private static int factorial(int n) {
        if (n == 0) return 1;
        return factorial(n-1) * n;
    }

    private static int max(int[] a, int lastIndex) {
        i f(lastIndex == 0) return a[0];
        int m = max(a, lastIndex-1);
        if (m > a[lastIndex]) return m;
        return a[lastIndex];
    }

    private static double average(int[] a,int i){
        if(i==0)return a[i];
        double av = average(a,i-1);
        return (av*i+a[i])/(i+1);
    }
    
    private static String charRemove(String str,char a){
        if(str.length()==0)return "";
        String n = charRemove(str.substring(0,str.length()-1),a);
        if(str.charAt(str.length()-1)==a)return n;
        return n+str.charAt(str.length()-1);
    }

    private static int maxPairSum(int[] a,int i,int n){
        if(n==0)return 0;
        if(i<0)return 0;
        int notPick = maxPairSum(a,i-1,n);
        int pick = maxPairSum(a,i-1,n-1)+a[i];
        if(notPick>pick)return notPick;
        return pick;
    }

    private static int GCD(int x,int y){
        if(y==0)return x;
        return GCD(y,x%y);
    }

    public static void main(String [] args) {
        System.out.println(strRev("123456789"));
        System.out.println(fibonacci(5));
        System.out.println(power(2,10));
        System.out.println(factorial(5));
        System.out.println(max(new int[]{1,2,3,12,5,6},5));
        System.out.println(charRemove("What the fuckkkkk",' '));

        System.out.println(maxPairSum(new int[]{99,2,8,12,5,6},5,2));
        System.out.println(GCD(6,3));
        System.out.println(avg(new int[]{1,2,3,4},3));
    }
}