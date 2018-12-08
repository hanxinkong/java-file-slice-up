package in;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class in_file {

	/*
	 * 
	 */
	public static long getwrite(String file, int index, long begin, long end) {

		long endp = 0L;
		RandomAccessFile in = null;
		RandomAccessFile out = null;
		try {
			in = new RandomAccessFile(new File(file), "r");
			out = new RandomAccessFile(new File(file + "_" + index + ".hxk"), "rw");

			byte[] b = new byte[1024];
			int n = 0;
			in.seek(begin);

			while (in.getFilePointer() <= end && (n = in.read(b)) != -1) {
				out.write(b, 0, n);
			}

			endp = in.getFilePointer();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return endp;
	}

	public static void getsplit(String file, int count) {

		RandomAccessFile raf = null;

		try {

			raf = new RandomAccessFile(new File(file), "r");
			long length = raf.length();
			long maxsize = length / count;
			long offset = 0L;
			for (int i = 0; i < count - 1; i++) {
				long fbegin = offset;
				long fend = (i + 1) * maxsize;
				offset = getwrite(file, i, fbegin, fend);

			}
			if (length - offset > 0) {
				getwrite(file, count - 1, offset, length);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
