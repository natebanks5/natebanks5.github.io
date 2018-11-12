/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Model class that uses an algorithm to 
 * decrypt using the Vigenere cipher
 * @author hoovb
 */
public class Vigenere {

    /**
     * Decrypts the digitized text using the
     * Vigenere cipher
     * @param text
     * @param key
     * @return 
     */
    public String decrypt(String text, String key) {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') {
                continue;
            }

            res += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        return res.charAt(0) + res.substring(1).toLowerCase();
}

}
