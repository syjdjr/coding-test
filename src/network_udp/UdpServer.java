package network_udp;

import java.io.*;
import java.net.*;

public class UdpServer {
    public static void main(String[] args) throws IOException {
        // 서버에서 입력을 받을 포트 번호를 3000으로 설정
        int port = 3000;

        // 3000번 포트로 오는 입력들을 받아줄 Socket을 생성
        DatagramSocket ds = new DatagramSocket(port); // socket() 및 bind()
        System.out.println("서버가 시작되었습니다. 클라이언트를 기다립니다.");

        while (true) {
            // 512byte만큼의 크기를 입력받을 수 있는 buffer 준비
            byte[] buffer = new byte[512];
            // buffer의 크기만큼의 입력을 담을 packet을 받을 공간 생성
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);

            // 3000번 포트로 오는 packet을 받아서 내용을 dp에 저장
            ds.receive(dp); // recvfrom()
            // 받은 packet의 내용을 출력
            String receivedName = new String(dp.getData(), 0, dp.getLength()).trim();
            System.out.println("클라이언트로부터 수신된 데이터: " + receivedName);

            // 클라이언트에게 보낼 학번
            String studentId = "20201857"; // 송신할 학번
            byte[] responseData = studentId.getBytes(); // 학번을 byte 배열로 변환

            // 클라이언트에게 학번 송신
            InetAddress clientAddress = dp.getAddress(); // 클라이언트 IP 주소
            int clientPort = dp.getPort(); // 클라이언트 포트 번호
            DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length, clientAddress, clientPort);
            ds.send(responsePacket);
        }
    }
}
