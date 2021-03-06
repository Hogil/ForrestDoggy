package forrest.command.ligoh;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuCommand {
	 String menuName;
	 Double menuPrice;
	 String recipe;
	 String menuIntro;
	 String allergy;
	 String menuType;
	 Integer menuSeq;
	 MultipartFile report;

	 
}
