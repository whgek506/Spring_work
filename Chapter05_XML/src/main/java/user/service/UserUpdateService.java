package user.service;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.collections4.map.HashedMap;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateService implements UserService{
	@Setter
	private UserDTO userDTO;
	@Setter
	private UserDAO userDAO;

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("아이디 입력 : ");
		String id = scan.next();
		UserDTO userDTO = userDAO.idCheck(id);

		if(userDTO == null) {
			System.out.println("아이디가 존재하지 않습니다.");
			return;
		}
		
		System.out.println(userDTO);
				
		System.out.println("수정 할 이름 입력 : ");
		String name = scan.next();
		System.out.println("수정 할 비밀번호 입력 : ");
		String pwd = scan.next();
				
		Map<String, String> map = new HashedMap<String, String>();
		map.put("name", name);
		map.put("id", id);
		map.put("pwd", pwd);
				
		userDAO.update(map);
				
		System.out.println(id + "님의 데이터 수정이 완료 되었습니다.");
	}

}