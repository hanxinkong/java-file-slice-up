package out;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class out_file {

	public static void merge(String file, String tempfile, int tempcount) {

		RandomAccessFile raf = null;

		try {
			raf = new RandomAccessFile(new File(file), "rw");

			for (int i = 0; i < tempcount; i++) {
				RandomAccessFile reader = new RandomAccessFile(new File(tempfile + "_" + i + ".hxk"), "rw");

				byte[] b = new byte[1024];
				int temp = 0;
				while ((temp = reader.read(b)) != -1) {
					raf.write(b, 0, temp);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				raf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
