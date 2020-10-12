package forrest.service.jm.Inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.controller.page.PageAction;
import forrest.domain.jm.CordDTO;
import forrest.domain.jm.StartEndPageDTO;
import forrest.mapper.jm.CordMapper;

@Component
@Service
public class CordListService {
	@Autowired
	CordMapper cordMapper;
	
	public void cordList(Model model, Integer page) throws Exception{
		int limit = 10;
		int limitPage = 10;
		
		Long startRow = ((long)page - 1) * 10 + 1;
		Long endRow = startRow + limit - 1;
		
		StartEndPageDTO dto = new StartEndPageDTO(startRow, endRow, null, null);
		
		List<CordDTO> lists = cordMapper.getCordList(dto);
		
		int count = cordMapper.getCordCount();
		
		model.addAttribute("count", count);
		model.addAttribute("lists", lists);
		PageAction pageAction = new PageAction();
		pageAction.page(model, count, limit, limitPage, page, "CordList");
		
	}
	
	
	
	
	
}
