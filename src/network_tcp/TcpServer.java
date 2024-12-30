package network_tcp;

import java.io.*;
import java.net.*;

public class TcpServer {
    public static void main(String[] args) throws IOException {
        // 서버의 포트 번호 설정
        int port = 12000; // 서버의 포트 번호를 12000으로 설정

        // 서버 소켓 생성
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("서버가 시작되었습니다. 클라이언트를 기다립니다.");

        while (true) {
            // 클라이언트 연결 수락
            Socket connectionSocket = serverSocket.accept(); // accept()
            System.out.println("연결 되었습니다.");

            // 연결된 클라이언트의 IP 주소와 포트 번호를 받아옴
            InetSocketAddress isa = (InetSocketAddress) connectionSocket.getRemoteSocketAddress();
            // 확인용
//            System.out.println("클라이언트 IP 주소 : " + isa.getHostName());
//            System.out.println("클라이언트 포트 번호 : " + isa.getPort());

            // 512bytes 크기의 buffer 생성
            byte[] buffer = new byte[512];

            // 클라이언트에서의 입력을 connectionSocket을 통해 수신
            InputStream is = connectionSocket.getInputStream();
            int readByteCount = is.read(buffer); // recv()

            if (readByteCount == -1) {
                // 클라이언트가 연결을 종료한 경우
                System.out.println("클라이언트가 연결을 종료했습니다.");
                connectionSocket.close(); // 연결 종료
                continue; // 다음 클라이언트를 기다림
            }

            // 수신된 데이터 처리
            String str = new String(buffer, 0, readByteCount);
            System.out.println("클라이언트로부터 수신된 데이터 : " + str);

            // 클라이언트에게 데이터를 전송
            OutputStream os = connectionSocket.getOutputStream();
            String studentId = "20201857"; // 전송할 학번
            os.write(studentId.getBytes());
            os.flush();
            System.out.println("데이터 전송 성공");

            // 연결 종료
            connectionSocket.close(); // 연결 종료

        }
    }
}
