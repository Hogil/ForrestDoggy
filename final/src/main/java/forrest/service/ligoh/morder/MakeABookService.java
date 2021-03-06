package forrest.service.ligoh.morder;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.AuthInfo;
import forrest.command.ligoh.MorderCommand;
import forrest.domain.ligoh.MenuListDTO;
import forrest.domain.ligoh.MorderDTO;
import forrest.mapper.ligoh.MorderListMapper;
import forrest.mapper.ligoh.MorderMapper;

@Service
@Component
public class MakeABookService {
	@Autowired
	MorderMapper morderMapper;
	@Autowired
	MorderListMapper morderListMapper;
	

	public void firstRegist(MorderCommand mc, HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		MorderDTO dto = new MorderDTO();
		
		
		Integer [] peopleCount = mc.getMordPeople();
		Integer sumPeople = 0;
		for (Integer people : peopleCount) {
			sumPeople += people;
		}
		
	
		Timestamp date =  Timestamp.valueOf(mc.getMordDate());
		
		dto.setMemId(authInfo.getId());
		dto.setMordPeople(sumPeople);
		dto.setMordDate(date);
		dto.setMenuReq(mc.getMenuReq());
		
		morderMapper.firstRegist(dto);
		
		
		
		
	}


	public void secondRegist(MorderCommand mc, HttpServletRequest request) throws Exception {
         
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		MorderDTO getNumber = morderMapper.getOrderNum(authInfo.getId());
		
		Integer [] peopleCount = mc.getMordPeople();
		Integer [] courses = mc.getCourseNum();
		
	    MenuListDTO mdto = new MenuListDTO();
	    mdto.setMordNum(getNumber.getMordNum());
	    
		for (int i = 0; i < courses.length; i++) {
			
				mdto.setCourseNum(courses[i]);
				mdto.setMordQty(peopleCount[i]);
				if (peopleCount[i]>0) {
					morderListMapper.insertCourse(mdto);
				  }
				
			  }
		
		Integer [] menues = mc.getMenuNum();
		Integer [] qty = mc.getDogMenuQty();
		
		 for (int i = 0; i < menues.length; i++) {
	    	  mdto.setMordQty(qty[i]);
	    	  mdto.setMenuNum(menues[i]);
	    	  if (menues[i]>0) {
	    		  morderListMapper.insertMenu(mdto);
			}
	    	  
		}
		
		
		
			
    }
	

}
