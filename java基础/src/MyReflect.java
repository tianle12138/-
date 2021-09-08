import com.tianle.Fruit;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class MyReflect {

    public static void main(String[] args) throws Exception {
        Class clz = Class.forName("Apple");
        Method getPriceMethod = clz.getMethod("getPrice");
        Constructor constructor = clz.getDeclaredConstructor();
        Object appleObj = constructor.newInstance();
        Object getPrice = getPriceMethod.invoke(appleObj);
        System.out.println("set 前 的 价 格： " + getPrice);
        Method setPriceMethod = clz.getMethod("setPrice", int.class);
        setPriceMethod.invoke(appleObj,100);
        // Object getPrice2 = getPriceMethod.invoke(appleObj);
        Field field = clz.getDeclaredField("price");

        field.setAccessible(true);
        Object price = field.get(appleObj);
        System.out.println("set 后 的 价 格： " + price);



        com.tianle.Fruit fruit = (com.tianle.Fruit)Class.forName("com.tianle.Fruit").getConstructor().newInstance();
        fruit.show();


    }

}

class Apple{
    private int price;

    Apple(){
        System.out.println("一个Apple对象生成了");
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }
}


