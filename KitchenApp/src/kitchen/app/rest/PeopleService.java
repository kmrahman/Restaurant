package kitchen.app.rest;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import kitchen.app.dao.PeopleDAO;
import kitchen.app.exception.AppException;
import kitchen.app.model.Person;
import kitchen.app.model.Contact;
import kitchen.app.model.Reservation;
import kitchen.app.rest.responses.AppResponse;

@Path("/people")
public class PeopleService {

	@GET
	@Path("/getCancel/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse cancelReservation(@PathParam("id") String reservationId) {

		AppResponse resp = new AppResponse();

		try {
			PeopleDAO dao = new PeopleDAO();
			String str = dao.cancelReservation(reservationId);
			resp.setPayload(str);

		} catch (AppException e) {
			e.printStackTrace();
			resp.setStatus(AppResponse.ERROR);
			resp.setMsg(e.getMessage());
		}

		return resp;
	}
	
	@GET
	@Path("/getReservation/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse getReservation(@PathParam("id") String reservationId) {

		AppResponse resp = new AppResponse();

		try {
			PeopleDAO dao = new PeopleDAO();
			Reservation person = dao.getReservation(reservationId);
			resp.setPayload(person);

		} catch (AppException e) {
			e.printStackTrace();
			resp.setStatus(AppResponse.ERROR);
			resp.setMsg(e.getMessage());
		}

		return resp;
	}


	
	@GET
	@Path("/contactList")
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse getContactList() {

		AppResponse resp = new AppResponse();

		try {
			PeopleDAO dao = new PeopleDAO();
			List<Contact> contactList = dao.getContactList();
			resp.setPayload(contactList);

		} catch (AppException e) {
			e.printStackTrace();
			resp.setStatus(AppResponse.ERROR);
			resp.setMsg(e.getMessage());
		}

		return resp;
	}

	@POST
	@Path("/addReservation")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse addReservation(Reservation reserve) {
		AppResponse resp = new AppResponse();

		try {
			PeopleDAO dao = new PeopleDAO();
			reserve = dao.addReservation(reserve);
			resp.setPayload(reserve);

		} catch (AppException e) {
			e.printStackTrace();
			resp.setStatus(AppResponse.ERROR);
			resp.setMsg(e.getMessage());
		}

		return resp;
	}

	
	
	@PUT
	@Path("/edit")
	public void editPerson() {

	}

	@DELETE
	@Path("/delete")
	public void deletePerson() {

	}
}

