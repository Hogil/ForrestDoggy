package forrest.command.jjj.ticket;

import lombok.Data;

@Data
public class TicketOrderCommand {
	
	Integer ticketNum[];
	String memId;
	Integer torderPrice;
	Integer tolistQty[];
	
}
