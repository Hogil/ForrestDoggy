package forrest.service.jjj.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.jjj.MemberDTO;
import forrest.mapper.jjj.MemberMapper;


@Service
@Component
public class MemberListService {

	@Autowired
	MemberMapper memberMapper;
	
	public void listMember(Model model) {
		List<MemberDTO> list = memberMapper.selectMemberAll();
		model.addAttribute("list" , list);
	}

}
