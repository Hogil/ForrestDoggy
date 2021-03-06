package forrest.service.jm.Inventory;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.jm.COrderCommand;
import forrest.domain.jm.COrderDTO;
import forrest.mapper.jm.COrderMapper;

@Service
@Component
public class COrderWriteProService {
	@Autowired
	COrderMapper corderMapper;
	
	public String writePro(COrderCommand corderCommand, HttpServletRequest request) throws Exception{
		
		COrderDTO dto = new COrderDTO();
		dto.setCordNum(corderCommand.getCordNum());
		dto.setCordQty(corderCommand.getCordQty());
		dto.setCordRegist(corderCommand.getCordRegist());
		dto.setGoodsName(corderCommand.getGoodsName());
		dto.setGoodsNum(corderCommand.getGoodsNum());
		dto.setPtName(corderCommand.getPtName());
		dto.setPtType(corderCommand.getPtType());
		
		corderMapper.corderInsert(dto);
		
		return "redirect:/inventory/corderList";
	}
	
	
	
	
}
