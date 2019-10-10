package Edureka;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GroupConversation {
    private static final String TERMINATE = "EXIT";
    static String name;
    static volatile boolean finished = false;
    public static void main(String[] args) throws IOException {
        if(args.length !=2){
            System.out.println("The two arguements rqd are <multicast host> <port no>");
        }else{
            InetAddress group = InetAddress.getByName(args[0]);
            int port = Integer.parseInt(args[1]);
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your name : ");
            name = sc.nextLine();
            MulticastSocket socket = new MulticastSocket(port);
            socket.setTimeToLive(0);
            socket.joinGroup(group);
            Thread t = new Thread(new ReadThread(socket,group,port));
            t.start();
            System.out.println("Start typing messages.....");
            while(true){
                String message;
                message=sc.nextLine();
                if(message.equalsIgnoreCase(GroupConversation.TERMINATE)){
                    finished=true;
                    socket.leaveGroup(group);
                    socket.close();
                    break;
                }
                message = name+":"+message;
                byte[] buffer = message.getBytes();
                DatagramPacket datagramPacket = new DatagramPacket(buffer,buffer.length,group,port);
                socket.send(datagramPacket);
            }
        }

    }


}

