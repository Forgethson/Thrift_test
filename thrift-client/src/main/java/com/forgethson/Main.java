package com.forgethson;

import com.forgethson.java_gen.User;
import com.forgethson.java_gen.UserService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;

import java.util.ArrayList;

public class Main {
    public static String THRIFT_HOST = "127.0.0.1";
    public static int THRIFT_PORT = 8888;

    public static void main(String[] args) throws TTransportException {
        TSocket tSocket = new TSocket(THRIFT_HOST, THRIFT_PORT, 2000);
        TFramedTransport m_transport = new TFramedTransport(tSocket);
        TBinaryProtocol protocol = new TBinaryProtocol(m_transport);
        UserService.Client client = new UserService.Client(protocol);

        try {
            m_transport.open();
            User user = client.getUserByName("wjd");
            System.out.println("getUserByName: user = " + user);
            boolean res = client.createUser(new User(0, "Jack", new ArrayList<>(), 8.99));
            if (res) {
                System.out.println("createUser successes");
            } else {
                System.out.println("createUser failed");
            }
            tSocket.close();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            m_transport.close();
        }
    }
}