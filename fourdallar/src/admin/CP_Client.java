package admin;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class CP_Client extends Thread{
	Socket s;
	Server server;

	// 객체 직렬화(objectInputStream, objectOutputStream)
	ObjectInputStream in;
	ObjectOutputStream out;
	String ip;
	
	public CP_Client(Socket s, Server server) {
		this.s = s;
		this.server = server;
		try {
			in = new ObjectInputStream(s.getInputStream());
			out = new ObjectOutputStream(s.getOutputStream());
		} catch (Exception e) {
		}
	}

	@Override
	public void run() {
		esc:while(true) {
			try {
				Object obj = in.readObject();
				if(obj!=null) {
					Protocol p = (Protocol) obj;
					switch(p.getCmd()) {
					case 0:	// 종료
						out.writeObject(p);
						out.flush();
						break esc; // 접속 해제
						
					case 601:	//회원관리 DB 전체보기: 정보 담아서 전송
						List<CustomerVO> list = DAO.getList();
						Protocol p601 = new Protocol();
						p601.setCmd(601);
						p601.setList(list);
						out.writeObject(p601);
						out.flush();
						break;
						

					}
				}
			} catch (Exception e) {
			}
		}
	}
	
}

/*
// 마이바티스 셋팅하기 
// 1. config.xml  만들기 - DB 접속
// 2. mapper.xml 만들기 - 실제 SQL 작성하는파일 (실제 DB에 갖다와서 결과를 내보내는 파일)
// 3. VO.java   - DB 에 들어갈 파라미터 및 결과를 저장을 담당하는 파일 (테이블의 컬럼명과 일치)
// 4. DAO.java  - mapper와 연결되서 자바에서  DB 실행 시키는 파일 (DB 처리흔 클래스들을 모아놓은 파일)
// 5. DBService - config.xml 파일을 읽고 MyBatis을 실행할 수 있도록 하는 파일  
*/
