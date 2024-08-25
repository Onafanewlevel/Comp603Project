
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
/**
 *
 * @author Onafanewlevel
 */
class Solution {
    public static void main(String[] args) {
        int x = 123454321;
        int y = 900080009;
        int z = 567898764;
        
        System.out.println(isPalindrome(x));
        System.out.println(isPalindrome(y));
        System.out.println(isPalindrome(z));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        long reversed = 0;
        long temp = x;

        while (temp != 0) {
            int digit = (int) temp % 10;
            reversed = reversed * 10 + digit;
            temp /= 10;
        }
        return (reversed == x);
    }
}
