package network_udp;

import java.io.*;
import java.net.*;

public class UdpClient {
    public static void main(String[] args) throws IOException {
        // UTF-8 인코딩으로 BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // localhost에 해당하는 IP 주소를 불러온다. -> 이 값은 127.0.0.1이다.
        InetAddress serverAddress = InetAddress.getByName("localhost"); // 서버의 IP 주소

        // 클라이언트 소켓 생성
        DatagramSocket socket = new DatagramSocket(); // 소켓 생성

        // 사용자로부터 이름 입력
        System.out.print("서버에 보낼 이름 입력: ");
        String name = br.readLine(); // BufferedReader를 이용하여 입력을 받는다.
        byte[] sendBuffer = name.getBytes(); // 입력받은 문자열을 UTF-8 인코딩의 byte 배열로 변환

        // 서버로 보낼 입력에 대한 정보를 담은 패킷 생성
        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, 3000);
        socket.send(sendPacket); // sendto() - 서버로 데이터 전송

        // 서버로부터 학번 수신을 위한 패킷 생성
        byte[] receiveBuffer = new byte[512]; // 수신할 데이터를 위한 buffer 생성
        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
        socket.receive(receivePacket); // recvfrom() - 서버로부터 데이터 수신

        // 서버에서 받아온 패킷을 보기 편하게 출력
        String studentId = new String(receivePacket.getData(), 0, receivePacket.getLength()).trim();
        System.out.println("수신한 데이터: " + studentId); // 수신된 학번 출력

        // 소켓 닫기
        socket.close();
        System.out.println("클라이언트가 종료되었습니다.");
    }
}
