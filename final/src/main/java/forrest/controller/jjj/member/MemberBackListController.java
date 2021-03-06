package forrest.controller.jjj.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.command.jjj.MemberCommand;
import forrest.service.jjj.member.MemberDeleteService;
import forrest.service.jjj.member.MemberDetailService;
import forrest.service.jjj.member.MemberListService;
import forrest.service.jjj.member.MemberModifyService;


@Controller
@RequestMapping("memberlist")
public class MemberBackListController {
	
	@Autowired
	MemberListService memberListService;
	@Autowired
	MemberDetailService memberDetailService;
	@Autowired
	MemberModifyService memberModifyService;
	@Autowired
	MemberDeleteService memberDeleteService;
	
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String memberList(Model model) {
		memberListService.listMember(model);
		return "thymeleaf/backOfficePage/html/member_manager/member_backMemberList";
	}
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String meberDetail(@RequestParam(value = "memId")String memId, Model model) {
		memberDetailService.detailService(memId,model);
		return "thymeleaf/backOfficePage/html/member_manager/member_backMemberDetail";
	}
	@RequestMapping(value = "memberModify", method = RequestMethod.GET)
	public String meberModify(@RequestParam(value = "memId")String memId, Model model) {
		memberDetailService.detailService(memId,model);
		return "thymeleaf/backOfficePage/html/member_manager/member_backMemberModify";
	}
	@RequestMapping(value = "memberModifyPro", method = RequestMethod.POST)
	public String meberModifyPro(@RequestParam(value = "memId")String memId, MemberCommand command) {
		memberModifyService.modifyService(memId,command);
		return "redirect:/memberlist/detail?memId="+memId;
	}
	@RequestMapping(value = "memberDelete", method = RequestMethod.GET)
	public String memberDelete(@RequestParam(value = "memId")String memId) {
		memberDeleteService.deleteService(memId);
		return "redirect:/memberlist/list";
	}
	
	
}
