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

        System.out.println("���ն�����......");

        // ����UDP��Socket����
        DatagramSocket ds = new DatagramSocket(9988);

        while (true) {
            // �������ݰ�
            num++;
            System.out.println("��ʼ���յ�" + num + "������");
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);

            // ʹ�ý��շ��������ݴ洢�����ݰ���
            ds.receive(dp); // �÷���Ϊ����ʽ�ķ���
            System.out.println("���յ����ݣ�");
            // ͨ�����ݰ�����ķ���������Щ���ݣ����磺��ַ���˿ڡ��������ݵ�
            String ip = dp.getAddress().getHostAddress();

            int port = dp.getPort();
            System.out.println("������������"+dp.getData());
            for (byte b:dp.getData()) {
                System.out.println(b);
            }

            System.out.println("-----------------utf-8---------------------");
            String text = new String(dp.getData(), 0, dp.getLength());
            System.out.println("Ĭ�ϣ�"+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("utf-8"),"utf-8");
            System.out.println("utf-8��"+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("utf-8"),"GBK");
            System.out.println("GBK��"+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("utf-8"),"GB2312");
            System.out.println("GB2312��"+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("utf-8"),"ISO-8859-1");
            System.out.println("ISO-8859-1��"+ip + ":" + port + ":" + text);


            System.out.println("-----------------GBK---------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            System.out.println("Ĭ�ϣ�"+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("GBK"),"utf-8");
            System.out.println("utf-8��"+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("GBK"),"GBK");
            System.out.println("GBK��"+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("GBK"),"GB2312");
            System.out.println("GB2312��"+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("GBK"),"ISO-8859-1");
            System.out.println("ISO-8859-1��"+ip + ":" + port + ":" + text);


            System.out.println("-----------------GB2312---------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            System.out.println("Ĭ�ϣ�"+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("GB2312"),"utf-8");
            System.out.println("utf-8��"+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("GB2312"),"GBK");
            System.out.println("GBK��"+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("GB2312"),"GB2312");
            System.out.println("GB2312��"+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("GB2312"),"ISO-8859-1");
            System.out.println("ISO-8859-1��"+ip + ":" + port + ":" + text);

            System.out.println("-----------------ISO-8859-1---------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            System.out.println("Ĭ�ϣ�"+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("ISO-8859-1"),"utf-8");
            System.out.println("utf-8��"+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("ISO-8859-1"),"GBK");
            System.out.println("GBK��"+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("ISO-8859-1"),"GB2312");
            System.out.println("GB2312��"+ip + ":" + port + ":" + text);
            System.out.println("--------------------------------------");
            text = new String(dp.getData(), 0, dp.getLength());
            text = new String(text.getBytes("ISO-8859-1"),"ISO-8859-1");
            System.out.println("ISO-8859-1��"+ip + ":" + port + ":" + text);


            System.out.println("-----------------------------end---------------------------------------");


        }
    }
}
