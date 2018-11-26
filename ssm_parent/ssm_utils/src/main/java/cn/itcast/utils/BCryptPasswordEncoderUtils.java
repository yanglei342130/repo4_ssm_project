package cn.itcast.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String passwordEncoding(String password){
       return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String s = passwordEncoding("123");
        System.out.println(s);
    }
}
