package user.service;

import java.util.List;
import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDeleteService implements UserService{
	@Setter
	private UserDTO userDTO;
	@Setter
	private UserDAO userDAO;

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("삭제 할 아이디 입력 : ");
		String id = scan.next();
		int num=0;
		
		List<UserDTO> list = userDAO.getUserList();
		
		for(UserDTO userDTO : list) {
			System.out.println(userDTO);
		if(userDTO.getId().equals(id)) {
			num=1;
			
			userDAO.delete(id);
			System.out.println(id + "님의 데이터를 삭제하였습니다.");
			
			break;
			}//if
		}//for
		if(num==0) System.out.println("아이디가 존재하지 않습니다.");
		
	}

}