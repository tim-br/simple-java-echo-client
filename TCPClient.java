import java.io.*;
import java.net.*;

class TCPClient
{
 public static void main(String argv[]) throws Exception
 {
  String sentence;
  String returnedSentence;
  Socket clientSocket = null;
  while(true){
  BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
  clientSocket = new Socket("199.103.57.66", 7999);
  DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
  BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
  sentence = inFromUser.readLine();
  outToServer.writeBytes(sentence + '\n');
  outToServer.flush();
  returnedSentence = inFromServer.readLine();
  System.out.println("FROM SERVER: " + returnedSentence);
  }
 }
}
