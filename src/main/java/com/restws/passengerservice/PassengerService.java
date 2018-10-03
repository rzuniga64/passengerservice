package com.restws.passengerservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import com.restws.model.Passenger;

@Produces("application/xml,application/json")
@Consumes("application/xml,application/json,application/x-www-form-urlencoded")
@Path("/passengerservice")
public interface PassengerService {

	/**
	 *  Get the list of passengers
	 * 	@param start the start of the list of passengers.
	 * 	@param size the size of the list of passengers.
	 * 	@return the list of passengers.
	 */
	@Path("/passengers")
	@GET
	List<Passenger> getPassengers(@QueryParam("start") int start, @QueryParam("size") int size);

	/**
	 * 	Add a passenger to the list of passengers.
	 * 	@param firstName the first name of the passenger.
	 * 	@param lastName	the last name of the passenger.
	 * 	@param agent	the agent that added the passenger.
	 * 	@param headers	the HTTP headers.
	 */
	@Path("/passengers")
	@POST
	void addPassenger(@FormParam("firstName") String firstName, @FormParam("lastName") String lastName, @HeaderParam("agent") String agent, @Context HttpHeaders headers);
}
