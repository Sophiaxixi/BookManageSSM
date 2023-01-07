import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: shlin
 * @Date: 2022/12/15 - 12 - 15 - 0:25
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
public class MainTest {

    @Test
    public void test(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("123456"));
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0,3);
        System.out.println(Character.isLetterOrDigit('c'));
    }



}
