package org.test.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/**
 * Created by zhangxingxing on 16/9/26.
 */
public class TestNgTest1 {

    @Test
    public void test1(){
        Assert.assertEquals(1,1);
    }

    @DataProvider(name = "getDataSource")
    public Object[][] getDataSource(){
        return new Integer[][]{new Integer[]{1,2} };
    }

    @Factory(dataProvider = "getDataSource")
    public Object[] createInstance(int a,int b){

        System.out.println(a);
        System.out.println(b);
        Test2[] result = new Test2[a+b];

        for (int i = 0; i < (a+b); i++) {
            result[i] = new Test2(i * 10);
        }
        return result;
    }


}


