package com.busRev.service;

import java.util.List;

import com.busRev.exception.AdminException;
import com.busRev.exception.RouteException;
import com.busRev.model.Route;

public interface RouteService {
	public Route addRoute(Route route,String key) throws RouteException, AdminException;
	public List<Route> viewAllRoute() throws RouteException;
	public Route viewRoute(int routeId) throws RouteException;
	public Route updateRoute(Route route,String key) throws RouteException, AdminException;
	public Route deleteRoute(int routeID,String key) throws RouteException, AdminException;
	
	
}
