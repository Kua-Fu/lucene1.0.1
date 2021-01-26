package org.apache.lucene.test;

import java.io.RandomAccessFile;

public class AccessIOTest {
    public static void main(String[] args) throws Exception {
        // testSeek();
        // testWrite();
        writeVInt(258);
    }

    public static void testSeek() throws Exception {
        String path = "test.txt";
        String mode = "rw";
        RandomAccessFile raf = null;
        raf = new RandomAccessFile(path, mode);
        raf.writeBytes("If you interesting to me,please give the kiss to me!");
        long seek = 10;
        raf.seek(seek);// 指定记录指针的位置
        long s = raf.getFilePointer();// 获取指针的位置
        int skipBytes = 1;
        raf.skipBytes(skipBytes);// 跳过的字节数
        byte[] buff = new byte[1024];
        int len = 0;
        while ((len = raf.read(buff)) > 0) {
            System.out.println(new String(buff, 0, len));
        }
    }

    public static void testWrite() throws Exception {
        int i = 258;
        byte b0 = (byte) (i >> 24);
        byte b1 = (byte) (i >> 16);
        byte b2 = (byte) (i >> 8);
        byte b3 = (byte) (i);
        int j = 0;
    }

    public static void writeVInt(int i) throws Exception {
        // int num = Integer.parseInt("7F", 16);
        // System.out.print(Integer.toBinaryString(num));
        // byte s1;
        while ((i & ~0x7F) != 0) {
            byte s1 = ((byte) ((i & 0x7f) | 0x80));
            String t = Byte.toString(s1);
            System.out.println("--s1 " + t);
            i >>>= 7;
        }
        byte s2 = ((byte) i);
        String t2 = Byte.toString(s2);
        System.out.println("--s2 " + t2);
    }
}

// public static void RandomAccess(String path,String mode,long seek,int
// skipBytes){
// RandomAccessFile raf = null;
// try {
// raf = new RandomAccessFile(path,mode);
// raf.writeBytes("If you interesting to me,please give the kiss to me!");
// raf.seek(seek);//指定记录指针的位置
// //System.out.println(raf.readLine());//使用seek指针指向0，readLine读取所有内容
// raf.getFilePointer();//获取指针的位置
// raf.skipBytes(skipBytes);//跳过的字节数
// byte[] buff = new byte[1024];
// int len = 0;
// while ((len = raf.read(buff))>0){
// System.out.println(new String(buff,0,len));
// }
// }catch (Exception e){
// e.printStackTrace();
// }finally {
// if(raf != null){
// try {
// raf.close();
// } catch (IOException e) {
// e.printStackTrace();
// }
// }
// }
// }