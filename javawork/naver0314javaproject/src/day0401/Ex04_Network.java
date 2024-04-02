package day0401;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ex04_Network {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		//자기 컴퓨터의 ip와 컴퓨터 이름 알아보기
		InetAddress local = InetAddress.getLocalHost();
		System.out.println("내 컴퓨터의 ip 주소 : "+local.getHostAddress());
		System.out.println("내 컴퓨터의 이름 : "+local.getHostName());
		
		
		System.out.println("naver 서버컴퓨터 ip");
		InetAddress[] naverInet = InetAddress.getAllByName("www.naver.com");
		for(InetAddress inet : naverInet) {
			System.out.println("naver ip : "+inet.getHostAddress());
		}
		System.out.println("google 서버 컴퓨터 ip");
		InetAddress[] googleInet = InetAddress.getAllByName("www.google.com");
		for(InetAddress inet : googleInet) {
			System.out.println("google ip : "+inet.getHostAddress());
		}
		System.out.println("코인플러그 서버 컴퓨터 ip");
		InetAddress[] cp = InetAddress.getAllByName("cplabs.io");
		for(InetAddress inet : cp) {
			System.out.println("코인플러그 서버 ip : "+inet.getHostAddress());
		}
		
	}

}
