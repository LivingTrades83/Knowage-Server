package it.eng.spagobi.tools.crossnavigation;

import it.eng.spago.security.IEngUserProfile;
import it.eng.spagobi.commons.constants.SpagoBIConstants;
import it.eng.spagobi.commons.dao.DAOFactory;
import it.eng.spagobi.services.rest.annotations.ManageAuthorization;
import it.eng.spagobi.services.rest.annotations.UserConstraint;
import it.eng.spagobi.services.serialization.JsonConverter;
import it.eng.spagobi.tools.crossnavigation.bo.NavigationDetail;
import it.eng.spagobi.tools.crossnavigation.bo.SimpleNavigation;
import it.eng.spagobi.tools.crossnavigation.dao.ICrossNavigationDAO;
import it.eng.spagobi.utilities.exceptions.SpagoBIServiceException;
import it.eng.spagobi.utilities.rest.RestUtilities;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

/**
 * @authors Salvatore Lupo (Salvatore.Lupo@eng.it)
 * 
 */
@Path("/1.0/crossNavigation")
@ManageAuthorization
public class CrossNavigationService {

	static protected Logger logger = Logger.getLogger(CrossNavigationService.class);

	@GET
	@Path("/listNavigation")
	@Produces(MediaType.APPLICATION_JSON)
	@UserConstraint(functionalities = { SpagoBIConstants.MANAGE_CROSS_NAVIGATION })
	public String listNavigation(@Context HttpServletRequest req) {
		try {
			ICrossNavigationDAO dao = DAOFactory.getCrossNavigationDAO();
			IEngUserProfile profile = (IEngUserProfile) req.getSession().getAttribute(IEngUserProfile.ENG_USER_PROFILE);
			dao.setUserProfile(profile);

			List<SimpleNavigation> lst = dao.listNavigation();

			return JsonConverter.objectToJson(lst, lst.getClass());
		} catch (Throwable t) {
			throw new SpagoBIServiceException(req.getPathInfo(), "An unexpected error occured while executing service", t);
		}
	}

	@GET
	@Path("/{id}/load")
	@Produces(MediaType.APPLICATION_JSON)
	@UserConstraint(functionalities = { SpagoBIConstants.MANAGE_CROSS_NAVIGATION })
	public String loadNavigation(@PathParam("id") Integer id, @Context HttpServletRequest req) {
		try {
			ICrossNavigationDAO dao = DAOFactory.getCrossNavigationDAO();
			IEngUserProfile profile = (IEngUserProfile) req.getSession().getAttribute(IEngUserProfile.ENG_USER_PROFILE);
			dao.setUserProfile(profile);
			NavigationDetail nd = dao.loadNavigation(id);
			return JsonConverter.objectToJson(nd, nd.getClass());
		} catch (Throwable t) {
			throw new SpagoBIServiceException(req.getPathInfo(), "An unexpected error occured while executing service", t);
		}
	}

	@GET
	@Path("/{id}/associations")
	@Produces(MediaType.APPLICATION_JSON)
	@UserConstraint(functionalities = { SpagoBIConstants.MANAGE_CROSS_NAVIGATION })
	public String listAssociations(@PathParam("id") String id, @Context HttpServletRequest req) {
		try {
			ICrossNavigationDAO dao = DAOFactory.getCrossNavigationDAO();
			IEngUserProfile profile = (IEngUserProfile) req.getSession().getAttribute(IEngUserProfile.ENG_USER_PROFILE);
			dao.setUserProfile(profile);

			// TODO
			return "";
		} catch (Throwable t) {
			throw new SpagoBIServiceException(req.getPathInfo(), "An unexpected error occured while executing service", t);
		}
	}

	@POST
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	@UserConstraint(functionalities = { SpagoBIConstants.MANAGE_CROSS_NAVIGATION })
	public String save(@Context HttpServletRequest req) {
		try {
			String requestVal = RestUtilities.readBody(req);
			NavigationDetail nd = (NavigationDetail) JsonConverter.jsonToObject(requestVal, NavigationDetail.class);
			ICrossNavigationDAO dao = DAOFactory.getCrossNavigationDAO();
			IEngUserProfile profile = (IEngUserProfile) req.getSession().getAttribute(IEngUserProfile.ENG_USER_PROFILE);
			dao.setUserProfile(profile);
			dao.save(nd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ok";
	}

}