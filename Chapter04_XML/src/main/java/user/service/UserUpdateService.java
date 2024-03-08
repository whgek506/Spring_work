package user.service;

import java.util.List;
import java.util.Scanner;

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
		int num = 0;
		
		List<UserDTO> list = userDAO.getUserList();
		
		System.out.println("아이디 입력 : ");
		String id = scan.next();

		for(UserDTO userDTO : list) {
			if(userDTO.getId().equals(id)) {
				
				System.out.println(userDTO);
				
				System.out.println("수정 할 이름 입력 : ");
				String name = scan.next();
				System.out.println("수정 할 비밀번호 입력 : ");
				String pwd = scan.next();
				num++;
				
				userDTO.setName(name);
				userDTO.setId(id);
				userDTO.setPwd(pwd);
				
				userDAO.update(userDTO);
				
				System.out.println(id + "님의 데이터 수정이 완료 되었습니다.");
				
				break;
			}//if
		}//for
		
		if(num==0) {
			System.out.println("아이디가 존재하지 않습니다.");
		}
	}

}
