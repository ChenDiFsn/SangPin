package s1JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class JdbcFangFaJi {
	static Scanner input = new Scanner(System.in);

	public static Connection lianJie(String url1, String sa, String password) {
		try {
			// ��������
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// �������ݿ��ַ
		String url = "jdbc:sqlserver://localhost;databaseName=" + url1 + "";
		// ����һ��java���ӿ�
		Connection conn = null;
		try {
			// ����java�����ݿ�����ӹܵ�
			conn = DriverManager.getConnection(url, sa, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}

	static String url = null;
	static String sa = null;
	static String password = null;

	// �����ӵ��˻��������ݿ��ַ��ֵ�ķ���
	public static Connection fuzhi() {
		System.out.println("���������ݿ���");
		url = input.next();
		System.out.println("�������˻�����");
		sa = input.next();
		System.out.println("�������˻�����");
		password = input.next();
		Connection conn = lianJie(url, sa, password);
		return conn;
	}

	// ������ķ���
	public static void ChuangBiao(String biao, String id, String name, String money) {
		// �������
		Connection con = fuzhi();
		// ���sql���
		String sql = "create table " + biao + "(" + id + " int," + name + " varchar(50)," + money + " float)";
		// ִ��sql���
		Statement st;
		try {
			st = con.createStatement();
			int i = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("�����ɹ�");

	}

	// ����ֶ�������
	public static void ChuangBiao() {
		// �������
		Connection con = fuzhi();
		// ���sql���
		String sql = "alter table shopping add �������� int";
		// ִ��sql���
		Statement st;
		try {
			st = con.createStatement();
			int i = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("�����ɹ�");

	}

	// ������ݵķ���
	public static void add(String name, double money, int shu) {
		// ��������
		Connection conn = lianJie("JDBC_db", "sa", "1804123028");
		// ���sql���
		String sql = "insert into shopping (ˮ������,����,��������) values ('" + name + "'," + money + "," + shu + ")";
		// ִ��sql���
		PreparedStatement pre = null;
		int i = 0;
		try {
			pre = conn.prepareStatement(sql);
			i = pre.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pre != null) {
					pre.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("������" + i + "������");
	}

	// ɾ�����ݵķ���
	public static void del(String ziName, String name) {
		// ��������
		Connection conn = lianJie("JDBC_db", "sa", "1804123028");
		// ���sql���
		String sql = "delete shopping where " + ziName + "='" + name + "'";
		// ִ��sql���
		PreparedStatement pre = null;
		int i = 0;
		try {
			pre = conn.prepareStatement(sql);
			i = pre.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pre != null) {
					pre.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("��ɾ��" + i + "������");

	}

	// ɾ�����ݵķ��������d
	public static void del(String ziName) {
		// ��������
		Connection conn = lianJie("JDBC_db", "sa", "1804123028");
		// ���sql���
		String sql = "delete shopping where ˮ������='" + ziName + "'";
		// ִ��sql���
		PreparedStatement pre = null;
		int i = 0;
		try {
			pre = conn.prepareStatement(sql);
			i = pre.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pre != null) {
					pre.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("��ɾ��" + i + "������");

	}

	// �޸ĵķ���
	public static void set(double set, String lie) {
		// ��������
		Connection conn = lianJie("JDBC_db", "sa", "1804123028");
		// ���sql���
		String sql = "update shopping set ����=" + set + "  where ˮ������= '" + lie + "'";
		// ִ��sql���
		PreparedStatement pre = null;
		int i = 0;
		try {
			pre = conn.prepareStatement(sql);
//			pre.setDouble(1, set);
//			pre.setString(2, lie);
			i = pre.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pre != null) {
					pre.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("���޸���" + i + "������");

	}

	// �޸ķ���������
	public static void set(String ziName, int lie) {
		// ��������
		Connection conn = lianJie("JDBC_db", "sa", "1804123028");
		// ���sql���
		String sql = "update shopping set ��������=" + lie + " where ˮ������='" + ziName + "'";
		// ִ��sql���
		PreparedStatement pre = null;
		int i = 0;
		try {
			// ִ��sql���
			pre = conn.prepareStatement(sql);
			i = pre.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pre != null) {
					pre.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("���޸���" + i + "������");
	}

	public static void set(String ziName, String name) {
		// ��������
		Connection conn = lianJie("JDBC_db", "sa", "1804123028");
		// ���sql���
		String sql = "update shopping set ˮ������='" + ziName + "' where ˮ������='" + name + "' ";
		// ִ��sql���
		PreparedStatement pre = null;
		int i = 0;
		try {
			// ִ��sql���
			pre = conn.prepareStatement(sql);
			i = pre.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pre != null) {
					pre.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("���޸���" + i + "������");
	}

	// ��ѯ����
	public static ArrayList<Biao> sel() {
		// ��������
		Connection conn = lianJie("JDBC_db", "sa", "1804123028");
		// ���sql���
		String sql = "select * from shopping";
		// ����һ���ϼ�����
		ArrayList<Biao> arr = new ArrayList<Biao>();
		Statement st = null;
		ResultSet res = null;

		try {
			// ִ��sql���Ԥ�������
			st = conn.createStatement();
			// ִ��sql���
			res = st.executeQuery(sql);
			while (res.next()) {
				Biao b = new Biao();
				b.setId(res.getInt("ID"));
				b.setName(res.getString("ˮ������"));
				b.setMoney(res.getFloat("����"));
				b.setShu(res.getInt("��������"));
				arr.add(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return arr;
	}

	// ��ѯ�����ط���
	public static ArrayList<Biao> sel(String ziName) {
		// ��������
		Connection conn = lianJie("JDBC_db", "sa", "1804123028");
		// ���sql���
		String sql = "select * from shopping where ˮ������='" + ziName + "'";
		// ����һ���ϼ�����
		ArrayList<Biao> arr = new ArrayList<Biao>();
		Statement st = null;
		ResultSet res = null;
		Biao b = null;
		try {
			// ִ��sql���Ԥ�������
			st = conn.createStatement();
			// ִ��sql���
			res = st.executeQuery(sql);
			b = new Biao();
			int con = 0;
			while (res.next()) {
				b.setId(res.getInt("ID"));
				b.setName(res.getString("ˮ������"));
				b.setMoney(res.getFloat("����"));
				b.setShu(res.getInt("��������"));
				arr.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return arr;
	}

	public static ArrayList<Biao> sel(int ziName) {
		// ��������
		Connection conn = lianJie("JDBC_db", "sa", "1804123028");
		// ���sql���
		String sql = "select * from shopping where ID=" + ziName + "";
		// ����һ���ϼ�����
		ArrayList<Biao> arr = new ArrayList<Biao>();
		Statement st = null;
		ResultSet res = null;
		Biao b = null;
		try {
			// ִ��sql���Ԥ�������
			st = conn.createStatement();
			// ִ��sql���
			res = st.executeQuery(sql);
			b = new Biao();
			int con = 0;
			while (res.next()) {
				b.setId(res.getInt("ID"));
				b.setName(res.getString("ˮ������"));
				b.setMoney(res.getFloat("����"));
				b.setShu(res.getInt("��������"));
				arr.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return arr;
	}

}
