/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import org.apache.thrift.server.THsHaServer.Args;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

/**
 *
 * @author vlad
 */
public class ThriftServer {
    
  public static StudentHandler handler;
  public static StudentService.Processor processor;

  public static void main(String [] args) {
  try {
        handler = new StudentHandler();
        processor = new StudentService.Processor(handler);
         
        Runnable simple = new Runnable() {
        public void run() {
            simple(processor);
        }
        };      
         
        new Thread(simple).start();
  } 
  catch (Exception x) {
      x.printStackTrace();
  }
  }

  public static void simple(StudentService.Processor processor) {
  try {
      TServerTransport serverTransport = new TServerSocket(9090);
      TServer server = new TSimpleServer(new Args((TNonblockingServerTransport) serverTransport).processor(processor));

      System.out.println("Starting the simple server...");
      server.serve();
  } 
  catch (Exception e) {
      e.printStackTrace();
  }
  }
}
