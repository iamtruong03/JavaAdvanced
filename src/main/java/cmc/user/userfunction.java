package cmc.user;

import object.*;
import util.*;
import java.sql.*;
import java.util.ArrayList;

public interface userfunction {

	public boolean addUser(UserObject item);
	public boolean editUser(UserObject item);
	public boolean delUser(UserObject item);
	
	public UserObject getUserObject(int id);
	public UserObject getUserObject(String username, String password);
	public ArrayList<UserObject> getUserObjects(UserObject similar, int at, byte total);
	
}
