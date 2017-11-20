package test;

/**
 * Created by zhj on 2017/11/15.
 */

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receive {


    private static long num = 0;
    public static void test(){
        byte[] data = new byte[]{};

    }

    public static void main(String[] args) throws Exception {

        System.out.println("接收端启动......");

        // 建立UDP的Socket服务
        DatagramSocket ds = new DatagramSocket(9988);

        while (true) {
            // 创建数据包
            num++;
            System.out.println("开始接收第" + num + "个数据");
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);

            // 使用接收方法将数据存储到数据包中
            ds.receive(dp); // 该方法为阻塞式的方法
            System.out.println("接收到数据！");
            // 通过数据包对象的方法解析这些数据，例如：地址、端口、数据内容等
            String ip = dp.getAddress().getHostAddress();

            int port = dp.getPort();
            System.out.println("二进制流量："+dp.getData());
            for (byte b:dp.getData()) {
                System.out.println(b);
            }

            System.out.println("-----------------utf-8---------------------");
            String text = new String(dp.getData(), 0, dp.getLength());
            System.out.println("默认："+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("utf-8"),"utf-8");
            System.out.println("utf-8："+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("utf-8"),"GBK");
            System.out.println("GBK："+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("utf-8"),"GB2312");
            System.out.println("GB2312："+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("utf-8"),"ISO-8859-1");
            System.out.println("ISO-8859-1："+ip + ":" + port + ":" + text);


            System.out.println("-----------------GBK---------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            System.out.println("默认："+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("GBK"),"utf-8");
            System.out.println("utf-8："+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("GBK"),"GBK");
            System.out.println("GBK："+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("GBK"),"GB2312");
            System.out.println("GB2312："+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("GBK"),"ISO-8859-1");
            System.out.println("ISO-8859-1："+ip + ":" + port + ":" + text);


            System.out.println("-----------------GB2312---------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            System.out.println("默认："+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("GB2312"),"utf-8");
            System.out.println("utf-8："+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("GB2312"),"GBK");
            System.out.println("GBK："+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("GB2312"),"GB2312");
            System.out.println("GB2312："+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("GB2312"),"ISO-8859-1");
            System.out.println("ISO-8859-1："+ip + ":" + port + ":" + text);

            System.out.println("-----------------ISO-8859-1---------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            System.out.println("默认："+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("ISO-8859-1"),"utf-8");
            System.out.println("utf-8："+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("ISO-8859-1"),"GBK");
            System.out.println("GBK："+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("ISO-8859-1"),"GB2312");
            System.out.println("GB2312："+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("ISO-8859-1"),"ISO-8859-1");
            System.out.println("ISO-8859-1："+ip + ":" + port + ":" + text);


            System.out.println("-----------------------------end---------------------------------------");


        }
    }
}
