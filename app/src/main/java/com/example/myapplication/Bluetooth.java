/**
package com.example.myapplication;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import com.example.myapplication.DotView;

public class Bluetooth {
    // Add this field to your activity
    private BluetoothAdapter mBluetoothAdapter;
    private AcceptThread mAcceptThread;

    // Add this method to your activity to start listening for incoming Bluetooth connections
    private void startBluetoothListening() {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        mAcceptThread = new AcceptThread();
        mAcceptThread.start();
    }

    // Add this class to your activity to create a thread for accepting incoming Bluetooth connections
    private class AcceptThread extends Thread {
        private final BluetoothServerSocket mmServerSocket = null;
        private boolean mStop = false;

        public AcceptThread() {
            BluetoothServerSocket tmp = null;
            try {
                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return TODO;
                }
                tmp = mBluetoothAdapter.listenUsingRfcommWithServiceRecord("MyApp", UUID.randomUUID());
            } catch (IOException e) {
                e.printStackTrace();
            }
            mmServerSocket = tmp;
        }

        public void run() {
            BluetoothSocket socket = null;
            while (!mStop) {
                try {
                    socket = mmServerSocket.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }

                if (socket != null) {
                    // A connection was accepted. Start a thread to read the data.
                    ConnectedThread connectedThread = new ConnectedThread(socket);
                    connectedThread.start();
                }
            }
        }

        public void cancel() {
            mStop = true;
            try {
                mmServerSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Add this class to your activity to create a thread for reading incoming data
    private class ConnectedThread extends Thread {
        private final BluetoothSocket mmSocket;
        private final InputStream mmInStream;

        public ConnectedThread(BluetoothSocket socket) {
            mmSocket = socket;
            InputStream tmpIn = null;

            try {
                tmpIn = socket.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }

            mmInStream = tmpIn;
        }

        public void run() {
            byte[] buffer = new byte[1024];
            int bytes;

            while (true) {
                try {
                    bytes = mmInStream.read(buffer);
                    String message = new String(buffer, 0, bytes);
                    int num = Integer.parseInt(message.trim());

                    // Update your dot position based on the received number
                    //dotPosition += num;
                    //dotView.setX(dotPosition);
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }

        public void cancel() {
            try {
                mmSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

 */
