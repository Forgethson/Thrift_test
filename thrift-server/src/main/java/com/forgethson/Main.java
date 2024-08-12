package com.forgethson;


import com.forgethson.java_gen.UserService;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;

public class Main {
    public static void main(String[] args) throws TTransportException {
        TProcessor processor = new UserService.Processor<>(new UserServiceImpl());
        TNonblockingServerSocket serverSocket = new TNonblockingServerSocket(8888);
        TNonblockingServer.Args tnbArgs = new TNonblockingServer.Args(serverSocket);
        tnbArgs.processor(processor);
        tnbArgs.transportFactory(new TFramedTransport.Factory());
        tnbArgs.protocolFactory(new TBinaryProtocol.Factory());
        // 使用非阻塞式IO，服务端和客户端需要指定TFramedTransport数据传输的方式
        TServer server = new TNonblockingServer(tnbArgs);
        server.serve();
        System.out.println("Server running...");
        System.out.println("Listening on port 8888");
    }
}