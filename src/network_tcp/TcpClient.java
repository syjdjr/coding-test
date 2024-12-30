package network_tcp;

import java.io.*;
import java.net.*;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        // 사용자 입력을 받기 위한 BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 서버에 보낼 소켓을 생성
        Socket socket = new Socket(); // 소켓 생성

        // 서버의 IP 주소와 포트 번호 설정
        InetSocketAddress serverAddress = new InetSocketAddress("localhost", 12000); // dest IP와 port 설정
        socket.connect(serverAddress); // connect() 메서드를 이용하여 서버와 연결
        System.out.println("서버에 연결되었습니다.");

        // 서버에 보낼 OutputStream 생성
        OutputStream os = socket.getOutputStream();
        // 서버로부터 데이터를 받을 InputStream 생성
        InputStream is = socket.getInputStream();

        // 서버에 보낼 내용을 입력
        System.out.print("영문 메시지 입력하세요: ");
        String str = br.readLine(); // 사용자 입력 받기
        byte[] buffer = str.getBytes(); // 입력받은 문자열을 byte 배열로 변환

        // 서버에 데이터 전송
        os.write(buffer); // buffer에 저장된 내용을 서버에 전송
        os.flush(); // 출력 스트림 비우기
        System.out.println("데이터 전송에 성공했습니다.");

        // 서버에서 다시 보내는 내용을 받아들임
        buffer = new byte[512]; // 수신할 데이터 버퍼 생성
        int readByteCount = is.read(buffer); // 서버로부터 데이터 수신

        // 수신된 데이터를 문자열로 변환하여 출력
        str = new String(buffer, 0, readByteCount).trim();
        System.out.println("수신된 데이터 : " + str);

        // 연결 종료
        socket.close(); // 소켓 닫기
        System.out.println("클라이언트가 종료되었습니다.");
    }
}
