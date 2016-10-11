package org.test.testng;

import org.testng.annotations.Test;

/**
 * Created by zhangxingxing on 16/9/26.
 */
public class Test2 {

    private static int num;

    int m_numberOfTimes;

    public Test2(int m_numberOfTimes){
        this.m_numberOfTimes = m_numberOfTimes;
    }

    @Test
    public void testServer(){
        num ++;
        System.out.println("num "+num + "--" + m_numberOfTimes);
    }

    @Test
    public void testServer2(){
        num ++;
        System.out.println("num "+num + "--" + m_numberOfTimes);
    }
}
