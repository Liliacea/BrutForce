public class BrutForse {
    public static void main(String[] args) {
        int[] weights = {5, 4, 2, 8, 6};
        int[] prices = {4, 2, 5, 3, 7,};
        int maxWeight = 13;
        long count = 2L << weights.length;
        int maxPrice = 0;
        long maxState = 0;

        for (long state = 0; state < count; state++) {
            int price = statePrice(state, prices);
            int weight = stateWeight(state, weights);
            if (weight <= maxWeight) {
                if (maxPrice < price) {
                    maxPrice = price;
                    maxState = state;
                }
            }

        }
        System.out.println("Оптимальное содержимое");
        long powerOfTwo = 1;
        for (int i = 0; i < weights.length; i++) {
            if ((powerOfTwo&maxState)>0){
                System.out.println(i+1);
            }
            powerOfTwo<<=1;
        }
    }


    private static int stateWeight(long state, int[] weights){
        long powerOfTwo = 1;
        int weight = 0;
        for (int i = 0; i < weights.length; i++) {
            if((powerOfTwo&state)!=0){
                weight += weights[i];
            }
            powerOfTwo <<= 1;

        }return weight;
    }
    private static int statePrice(long state, int[] prices){
        long powerOfTwo = 1;
        int price = 0;
        for (int i = 0; i < prices.length; i++) {
            if((powerOfTwo&state)!=0){
                price+=prices[i];
            }
            powerOfTwo <<=1;
        } return price;
    }

}
