package test.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Date;

public class FileOP {
	
	public static void main(String[] args) throws Exception {
		
		Date s = new Date();
		FileInputStream in = new FileInputStream("D:\\迅雷下载\\Thunder7.9.exe");
		FileChannel fc1 = in.getChannel();
		
		FileOutputStream out = new FileOutputStream("D:\\迅雷下载\\Thunder7.9temp.exe");
		FileChannel  fout = out.getChannel();
		
		ByteBuffer bb =  ByteBuffer.allocate(10000);
		
		int len = -1;
		while((len = fc1.read(bb)) != -1){
			bb.flip();
			fout.write(bb);
			bb.clear();
		}
		in.close();
		fc1.close();
		out.close();
		fout.close();
		System.out.println(new Date().getTime() - s.getTime());
		
		Date s2 = new Date();
		FileInputStream ins = new FileInputStream("D:\\迅雷下载\\Thunder7.9.exe");
		FileOutputStream outs = new FileOutputStream("D:\\迅雷下载\\Thunder7.9temp2.exe");
		
		byte[] bytes = new byte[10000];
		int length = -1;
		while((length = ins.read(bytes)) != -1){
			
			outs.write(bytes, 0, length);
		}
		ins.close();
		outs.close();
		System.out.println(new Date().getTime() - s2.getTime());
	}

}
