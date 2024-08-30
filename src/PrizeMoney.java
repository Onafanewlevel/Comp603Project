/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Onafanewlevel
 */
public enum PrizeMoney {
    LEVEL_0(0),
    LEVEL_1(100),
    LEVEL_2(200),
    LEVEL_3(300),
    LEVEL_4(500),
    LEVEL_5(1000),
    LEVEL_6(2000),
    LEVEL_7(4000),
    LEVEL_8(8000),
    LEVEL_9(16000),
    LEVEL_10(32000),
    LEVEL_11(64000),
    LEVEL_12(125000),
    LEVEL_13(250000),
    LEVEL_14(500000),
    LEVEL_15(1000000);

    private final int amount;

    PrizeMoney(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    // Static method to get prize money by question number
    public static int getPrizeByQuestionNumber(int questionNumber) {
        return PrizeMoney.values()[questionNumber].getAmount();
    }
}
