package com.demo.nettybase;


import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Nullen
 */
@Slf4j
public class TestByteBuffer {
    public static void main(String[] args) {
        // FileChannel
        // 1. 输入输出流; 2. RandomAccessFile
        try (FileChannel channel = new FileInputStream("hello.txt").getChannel()) {
            // 准备缓冲区, 指定缓冲区大小(Byte), 可以理解为一个指定长度的数组
            ByteBuffer buffer = ByteBuffer.allocate(10);
            
            // 从缓冲区读取数据, 即写到缓冲区
            // channel.read(buffer);
            // 打印buffer内容
            // buffer.flip(); // 1. 先将buffer切换至读模式
            // while (buffer.hasRemaining()) { // 检查Buffer内是否还有未读的数据
            //     byte b = buffer.get();
            //     // 强转为字符
            //     System.out.println((char) b);
            // }

            // 上面这种方式只能读取到10个字符, 而文件内容不一定小于10个字符, 所以需要改为下面这种方式
            while (true) {
                // 读取到的字节数, 若未读取到内容则返回值为-1
                int len = channel.read(buffer);
                log.info("读取到的字节数: {}", len);
                if (len == -1) {
                    break;
                }

                // 切换到读模式, 本质就是将position指针重新指向0
                buffer.flip();
                while (buffer.hasRemaining()) {
                    log.info("{}", (char) buffer.get());
                }
                // 切换至写模式, 本质就是清空缓冲区, 然后将指针重新指定到0
                buffer.clear();
                // 也可以通过实现切换至写模式, 本质是将未读部分进行压缩, 将指针指向未读的结束位, 效率低于clear
                // buffer.compact();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
