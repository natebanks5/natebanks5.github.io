/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Caesar cipher algorithm to decrypt text with a shift of 7
 *
 * @author hoovb
 */
public class Caesar {

    /**
     * Algorithm to decrypt message using Caesar cipher by a shift of 7
     *
     * @param text
     * @return
     */
    public String decrypt(String text) {
        StringBuffer result = new StringBuffer();
        int shift = 7;
        shift = 26 - shift;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char) (((int) text.charAt(i)
                        + shift - 65) % 26 + 65);
                result.append(ch);
            } else if (text.charAt(i) != ' ') {
                char ch = (char) (((int) text.charAt(i)
                        + shift - 97) % 26 + 97);
                result.append(ch);
            } else if (text.charAt(i) == ' ') {
                result.append(" ");
            }
        }
        return result.toString();
    }
}
