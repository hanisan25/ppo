package com.emotiv.examples.EmoStateLogger;

/**
 * Created by alkimo on 12/5/2016.
 */
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.io.*;

class NodeCommunicator {

    public static void main(String[] args) {
        try {
            Socket nodejs = new Socket("localhost", 8080);
            Thread.sleep(100);
            for (int i = 1; i < 100; i++) {
                Thread.sleep(500);
                sendMessage(nodejs, i + " ");
                System.out.println(i + " has been sent to server");
            }

        } catch (Exception e) {
            System.out.println("Server Closed..Something went Wrong..");
            e.printStackTrace();
        }
    }

    public static void sendMessage(Socket s, String message) throws IOException {
        System.out.println("In SendMesage" + message);
        s.getOutputStream().write(message.getBytes("UTF-8"));
        s.getOutputStream().flush();
    }

    public void scream(Socket s, String message) throws IOException {
        try {
            System.out.println("In SendMesage: " + message);
            s.getOutputStream().write(message.getBytes("UTF-8"));
            s.getOutputStream().flush();
        } catch (Exception e) {
            System.out.println("Server Closed..Something went Wrong..");
            e.printStackTrace();
        }
    }
}