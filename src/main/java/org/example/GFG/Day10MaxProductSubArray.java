package org.example.GFG;

public class Day10MaxProductSubArray {
    public static void main(String[] args) {
        int[] arr = {-2, 6, -3, -10, 0, 2};
        int maxProduct = arr[0], subArrayProduct;

        // approach 1
        for (int i=0;i<arr.length;i++){
            subArrayProduct = 1;
            for (int j=i;j<arr.length;j++){
                subArrayProduct = subArrayProduct*arr[j];
                if (subArrayProduct>maxProduct){
                    maxProduct = subArrayProduct;
                }
            }
        }
        System.out.println("Max Product Sub array value is :"+maxProduct);
        int maxProductVal = getMaxSubArrayProduct(arr);
        System.out.println("Max product of sub array using effiecient approach is "+maxProductVal);



    }

    private static int getMaxSubArrayProduct(int[] arr) {
        int n = arr.length-1;
        int leftToRight = 1;
        int rightToLeft = 1;
        int maxProductVal  =1;
        for(int i=0;i<arr.length;i++){

            if (leftToRight==0){
                leftToRight=1;
            }
            if (rightToLeft==0){
                rightToLeft=1;
            }

            // calculate the left to right product
            leftToRight = leftToRight*arr[i];

            // to calculate the right to left product
            int j = n-i;
            rightToLeft = rightToLeft*arr[j];

            // its ideally comparing max val among lefttoRight and righttoleft and maxProductvalue.
            // so we can compare in any of the below three ways
            maxProductVal = Math.max(Math.max(leftToRight,maxProductVal),Math.max(rightToLeft,maxProductVal));
           // maxProductVal = Math.max(leftToRight,Math.max(rightToLeft,maxProductVal));
            //maxProductVal = Math.max(Math.max(leftToRight,maxProductVal),rightToLeft);
        }
        return maxProductVal;
    }

}
