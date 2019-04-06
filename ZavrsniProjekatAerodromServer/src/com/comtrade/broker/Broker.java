package com.comtrade.broker;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

import com.comtrade.connection.Connections;
import com.comtrade.domen.Airline;
import com.comtrade.domen.CommonDomen;
import com.comtrade.domen.Flight;
import com.comtrade.domen.Staff;
import com.comtrade.domen.Ticket;
import com.comtrade.domen.User;
import com.mysql.fabric.xmlrpc.base.Value;

public class Broker implements IBroker{

	@Override
	public void save(CommonDomen cd) {
		String inquiry= "insert into "+cd.returnNameForTable()+""+cd.returnNameForColumn()+""+cd.returnNameForInsert();
		Statement st;
		try {
			st = Connections.getObject().getCon().createStatement();
			st.execute(inquiry);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	@Override
	public int returnValue(User user) {
		String inquiry="select * from user where username ='"+user.getUserName()+"' and password ='"+user.getPassword()+"'";
		Statement st;
		int value=0;
		try {
			st = Connections.getObject().getCon().createStatement();
			
			ResultSet rs=st.executeQuery(inquiry);
			if(rs.next()) {
				value=rs.getInt("id_user");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return value;
	}

	@Override
	public Staff returnValue(Staff staff) {
		String upit="select * from staff where username ='"+staff.getUsername()+"' and password ='"+staff.getPassword()+"'";
		Statement st;
		int status=0;
		int value =0;
		Staff s=new Staff();
		try {
			st = Connections.getObject().getCon().createStatement();
			
			ResultSet rs=st.executeQuery(upit);
			if(rs.next()) {
				status= rs.getInt("status");
				value = rs.getInt("id_staff");
				
				s.setStatus(status);
				s.setId_staff(value);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return s;
	}	
	
	

	@Override
	public List<Airline> returnAirline(Airline a)	 {
		String inquiry="select * from airline ";
		Statement st;
		//where company_name ='"+ a.getCompany_name()+"'and airport_name='"+a.getAirport_name()+"
		ArrayList<Airline>listA=new ArrayList<>();
		try {
			st = Connections.getObject().getCon().createStatement();
			
			ResultSet rs=st.executeQuery(inquiry);
			while(rs.next()) {
				Airline aa=new Airline();
				aa.setId_airline(rs.getInt("id_airline"));
				aa.setCompany_name(rs.getString("company_name"));
				aa.setAirport_name(rs.getString("airport_name"));
				
				listA.add(aa);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	
	
		return listA;
		
	

}

	@Override
	public List<CommonDomen> returnFlight(Flight f) {
		String inquiry="select * from flights ";
		Statement st;
		
		List<CommonDomen>listF=new ArrayList<>();
		try {
			st = Connections.getObject().getCon().createStatement();
			
			ResultSet rs=st.executeQuery(inquiry);
			while(rs.next()) {
				Flight f1 = new Flight();
				f1.setId_flight(rs.getInt("id_flights"));
				f1.setId_airline(rs.getInt("id_airline"));
				f1.setStatus(rs.getString("status"));
				f1.setStarting_point(rs.getString("starting_point"));
				f1.setDestination(rs.getString("destination"));
				f1.setArrival_time(rs.getString("arrival_time"));
				f1.setDeparture_time(rs.getString("departure_time"));
				f1.setDate(rs.getString("date"));
				f1.setTickets(rs.getInt("tickets"));
				
				listF.add(f1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	
	
		return listF;
		
	}

	@Override
	public List<CommonDomen> checkDate(Flight f) {
		
		
		String inquiry="SELECT reservation.bought_tickets as bought_tickets , flights.id_flights, flights.starting_point,flights.destination, flights.arrival_time, flights.departure_time, flights.date, (case when (bought_tickets is not null ) then flights.tickets-sum(reservation.bought_tickets) else flights.tickets end) as tickets_left FROM `flights`left join reservation on flights.id_flights=reservation.id_flights "+
				"where flights.date between '"+f.getDate()+"' and '"+f.getDate()+"'  group by reservation.id_flights  ";
		Statement st = null;
		ResultSet rs = null;
		//ArrayList<Flight>listF=new ArrayList<>();
		//try {
			try {
				st = Connections.getObject().getCon().createStatement();
				rs = st.executeQuery(inquiry);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<CommonDomen>listF = f.manageSelect(rs);
			/*while(rs.next()) {
				Flight f2 = new Flight();
				f2.setId_flight(rs.getInt("id_flights"));
				//f2.setId_airline(rs.getInt("id_airline"));
				//f2.setStatus(rs.getString("status"));
				f2.setStarting_point(rs.getString("starting_point"));
				f2.setDestination(rs.getString("destination"));
				f2.setArrival_time(rs.getString("arrival_time"));
				f2.setDeparture_time(rs.getString("departure_time"));
				f2.setDate(rs.getString("date"));
				f2.setTickets(rs.getInt("preostale"));
				
				listF.add(f2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	*/
	
		return listF;
	}

	@Override
	public List<CommonDomen> returnTicket(Ticket t) {
	
		String inquiry="SELECT reservation.bought_tickets, reservation.id_flights, flights.starting_point, flights.destination, flights.arrival_time, flights.departure_time, flights.date FROM `flights` inner join reservation on flights.id_flights=reservation.id_flights inner join user on user.id_user = reservation.id_user where reservation.id_user='"+t.getIdUsera()+"' and flights.date between '"+t.getDate()+"'and '"+t.getDate()+"'" ;
		Statement st = null;
		ResultSet rs = null;
		//ArrayList<Flight>listF=new ArrayList<>();
		//try {
			try {
				st = Connections.getObject().getCon().createStatement();
				rs = st.executeQuery(inquiry);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<CommonDomen>listT = t.manageSelect(rs);
		return listT;
	}
}
