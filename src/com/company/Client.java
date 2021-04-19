package com.company;

import java.io.*;
import java.net.Socket;

public class Client {
    public static int PORT=5000;

    public static void main(String[] args) throws IOException {

        Socket soc = new Socket(("localhost"),PORT); //We setup a connection between the client and the host on IP-address "localhost" and PORT (5000)
        System.out.println("Connection succesfull!");

        byte [] b = new byte[2002];
        InputStream is = soc.getInputStream(); //We read the output stream of the server by making an input stream on the client
        is.read(b, 0, b.length); //the stream gets read
        FileOutputStream fr = new FileOutputStream("C:\\Users\\tomra\\Documents\\receivedFromServer.txt"); //name the file and specify the place where we want to copy the file to
        fr.write(b, 0, b.length); //then we fill the new file with the content of the original file

        fr.close(); //When the client has received the file everything can be closed (streams and socket)
        is.close();
        soc.close();
        System.out.println("File is transferred: Client is done!");
    }
}