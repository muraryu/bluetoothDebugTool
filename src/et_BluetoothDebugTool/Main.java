package et_BluetoothDebugTool;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

import java.io.InputStream;

public class Main {

	public static void main(String[] args) {

		try
		{

			//=====================================================================================
			//シリアルポートを確保する

			//使用するCOMポートを取得
			CommPortIdentifier comID = CommPortIdentifier.getPortIdentifier("COM9");

			//COMポートを開きます
			CommPort commPort = comID.open("hoge", 2000);

			//シリアルポートのインスタンスを生成…
			SerialPort port = (SerialPort) commPort;

			//=====================================================================================
			//シリアルポートの設定

			//ボーレート、データビット数、ストップビット数、パリティを設定
			port.setSerialPortParams(128000, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

			//フロー制御はしない
			port.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);

			//=====================================================================================
			//ストリームを生成して、１文字ずつ送信していきます
			/*
			OutputStream out = port.getOutputStream();

			out.write( 'r' );
			out.write( 'i' );
			out.write( 'g' );
			out.write( 'h' );
			out.write( 't' );
			out.write( '\r' );
			*/

			while (true) {
				byte[] buf = new byte[1024];
				InputStream is = port.getInputStream();
				while (is.available() != 0) {
					is.read(buf);
				}

				System.out.print(new String(buf, 0, 1024) + "\n");
				Thread.sleep(1000);
			}

			//=====================================================================================
			//ストリームとCOMポートを閉じる処理

			//port.close();

		} catch (Exception e)
		{
			System.out.println("Error発生:" + e);
		}

	}
}
