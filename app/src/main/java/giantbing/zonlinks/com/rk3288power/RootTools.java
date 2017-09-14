package giantbing.zonlinks.com.rk3288power;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class RootTools {

	public synchronized static void sendDataToServiceProgram(final byte[] data) {
		if (null != data && data.length > 0) {
			Thread threadComm = new Thread() {
				public void run() {
					super.run();
					try {
						Socket socketComm = new Socket("127.0.0.1", 20699);
						OutputStream os = socketComm.getOutputStream();
						os.write(data);
						os.flush();
						os.close();
						socketComm.close();
					} catch (UnknownHostException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			};
			threadComm.start();
			try {
				threadComm.interrupt();
				threadComm.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
