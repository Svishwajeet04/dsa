package recursions;


//minimum number of coins required to make an amount
public class CoinExchangeMin {

    public static void main(String[] args) {
        int [] coins = new int[] {2, 3};
        int amount = 14;
        int count = minCoinExchange(coins, amount);
        System.out.println(count);
    }
    public static Integer [] arr;
    public static int minCoinExchange(int[] coins, int amount){
        if(arr ==  null){
            arr = new Integer[amount + 1];
        }
        if(amount == 0){
            return 0;
        }else if(amount < 0){
            return -1;
        }
        if(arr[amount] != null){
            return arr[amount];
        }
        {
            int count = -1;
            for (int coin : coins) {
                int ex = minCoinExchange(coins, amount - coin);
                if(ex != -1 && (count > ex || count == -1)){
                    count = ex;
                }
            }
            if(count != -1){
                return arr[amount] = count + 1;
            }else{
                return arr[amount] = count;
            }
        }
    }
}
