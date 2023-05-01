/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Santiago
 */
public class Utilidades {
    public static class UtilidadesString{
        public static String getSha256(String input){
            return DigestUtils.sha256Hex(input);
        }
    }
   
}
