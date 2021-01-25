package it.eng.spagobi.functions.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import it.eng.spago.error.EMFUserError;
import it.eng.spagobi.analiticalmodel.document.bo.BIObject;

public interface IBIObjFunctionDAO {

	public ArrayList<BIObject> getBIObjectsUsingFunction(Integer functionId, Session currSession) throws EMFUserError;

	public void eraseBIObjFunctionByObjectId(Integer biObjId) throws EMFUserError;

	public void eraseBIObjFunctionByObjectId(Integer biObjId, Session currSession) throws EMFUserError;

	public void updateObjectFunctions(BIObject biObj, List<Integer> functionIds, Session currSession) throws EMFUserError;

	public ArrayList<BIObjFunction> getBiObjFunctions(Integer biObjId, Session currSession) throws EMFUserError;
}