package cmc.user;

import java.util.ArrayList;
import java.sql.*;
import object.UserObject;
import util.ConnectionPool;
import util.ConnectionPoolImpl;

public class userfunctionImpl implements userfunction {

	// đối tg kết nối để làm việc
	private Connection con;

	public userfunctionImpl(ConnectionPool cp) {
		if (cp == null) {
			cp = new ConnectionPoolImpl();
		}
		//
		try {
			this.con = cp.getConnection("User");
			// k tra che do thuc thi tu dong
			if (this.con.getAutoCommit()) {
				// cham dut thuc thi tu dong
				this.con.setAutoCommit(false);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private boolean exe(PreparedStatement pre) {
		// pre da dc bien dich va truyen gtri day du cho cac tham so
		if(pre!=null) {
			try {
				int results = pre.executeUpdate();
				if (results==0) {
					this.con.rollback();
					return false;
				}
				
				this.con.commit();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				try {
					this.con.rollback();
				} catch (Exception e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
			} finally {
				pre = null;
			}
		}
		return false;
	}

	@Override
	public boolean addUser(UserObject item) {
		// TODO Auto-generated method stub
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tbluser(");
		sql.append("user_name, user_pass, user_fullname, user_birthday,");
		sql.append("user_mobilephone, user_homephone, user_officephone, user_email,");
		sql.append("user_address, user_jobarea, user_job, user_position,");
		sql.append("user_applyyear, user_permission, user_notes, user_roles,");
		sql.append("user_logined, user_created_date, user_last_modified, user_last_logined,");
		sql.append("user_parent_id, user_actions, user_deleted) ");
		sql.append("VALUE(?,md5(?),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			
			pre.setString(1, item.getUser_name());
			pre.setString(2, item.getUser_pass());
			pre.setString(3, item.getUser_fullname());
			pre.setString(4, item.getUser_birthday());
			pre.setString(5, item.getUser_mobilephone());
			pre.setString(6, item.getUser_homephone());
			pre.setString(7, item.getUser_officephone());
			pre.setString(8, item.getUser_email());
			pre.setString(9, item.getUser_address());
			pre.setString(10, item.getUser_jobarea());
			pre.setString(11, item.getUser_job());
			pre.setString(12, item.getUser_position());
			pre.setShort(13, item.getUser_applyyear());
			pre.setByte(14, item.getUser_permission());
			pre.setString(15, item.getUser_notes());
			pre.setString(16, item.getUser_roles());
			pre.setInt(17, item.getUser_logined());
			pre.setString(18, item.getUser_created_date());
			pre.setString(19, item.getUser_last_modified());
			pre.setString(20, item.getUser_last_logined());
			pre.setInt(21, item.getUser_parent_id());
			pre.setByte(22, item.getUser_actions());
			pre.setBoolean(23, item.isUser_deleted());

			return this.exe(pre);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public boolean editUser(UserObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delUser(UserObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserObject getUserObject(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserObject getUserObject(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserObject> getUserObjects(UserObject similar, int at, byte total) {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM tbluser ";
		sql += "";
		sql += "ORDER BY user_id DESC ";
		sql += "LIMIT " + at + "," + total;

		ArrayList<UserObject> list = new ArrayList<UserObject>();
		UserObject item = null;

		//
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			// lay tap ket qua
			ResultSet rs = pre.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					item = new UserObject();
					item.setUser_id(rs.getInt("user_id"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_fullname(rs.getString("user_fullname"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_pass(rs.getString("user_pass"));
					list.add(item);

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			// quay tro lai trang thai an toan
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		return list;
	}
	public static void main(String[] args) {
		//
		ConnectionPool cp = new ConnectionPoolImpl();
		//
		userfunction  uf = new userfunctionImpl(cp);
		
		//doi tuong ng su dung moi
		UserObject nItem = new UserObject();
		nItem.setUser_name("javanangcao");
		nItem.setUser_fullname("Chu Xuan Loc");
		nItem.setUser_pass("123456");
		nItem.setUser_created_date("8/5/2024");
		nItem.setUser_email("loc@gmail.com");
		
		boolean results = uf.addUser(nItem);
		if(!results) {
			System.out.print("\n----KHONG THANH CONG---\n");
		}
		
		// danh sach doi tuong
		ArrayList<UserObject> list = uf.getUserObjects(null, 0, (byte)10);
		list.forEach(u->{
			System.out.println(u);
		});
	}

}
