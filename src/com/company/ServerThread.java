package com.company;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {

            FileInputStream fr = new FileInputStream("C:\\Users\\tomra\\Downloads\\test.txt"); //we choose the File that serves as the input
            byte b[] =new byte[2002];
            fr.read(b,0, b.length); //We read the content of the file
            OutputStream os = socket.getOutputStream();
            os.write(b, 0, b.length); //The content of the file gets written to the servers output stream



        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
