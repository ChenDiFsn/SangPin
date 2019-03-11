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
			// 加载驱动
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 连接数据库地址
		String url = "jdbc:sqlserver://localhost;databaseName=" + url1 + "";
		// 创建一个java连接口
		Connection conn = null;
		try {
			// 建立java到数据库的连接管道
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

	// 给连接的账户密码数据库地址赋值的方法
	public static Connection fuzhi() {
		System.out.println("请输入数据库名");
		url = input.next();
		System.out.println("请输入账户名称");
		sa = input.next();
		System.out.println("请输入账户密码");
		password = input.next();
		Connection conn = lianJie(url, sa, password);
		return conn;
	}

	// 创建表的方法
	public static void ChuangBiao(String biao, String id, String name, String money) {
		// 添加驱动
		Connection con = fuzhi();
		// 添加sql语句
		String sql = "create table " + biao + "(" + id + " int," + name + " varchar(50)," + money + " float)";
		// 执行sql语句
		Statement st;
		try {
			st = con.createStatement();
			int i = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("创建成功");

	}

	// 添加字段名方法
	public static void ChuangBiao() {
		// 添加驱动
		Connection con = fuzhi();
		// 添加sql语句
		String sql = "alter table shopping add 货物数量 int";
		// 执行sql语句
		Statement st;
		try {
			st = con.createStatement();
			int i = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("创建成功");

	}

	// 添加数据的方法
	public static void add(String name, double money, int shu) {
		// 加载驱动
		Connection conn = lianJie("JDBC_db", "sa", "1804123028");
		// 添加sql语句
		String sql = "insert into shopping (水果名称,单价,货物数量) values ('" + name + "'," + money + "," + shu + ")";
		// 执行sql语句
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
		System.out.println("共插入" + i + "条数据");
	}

	// 删除数据的方法
	public static void del(String ziName, String name) {
		// 加载驱动
		Connection conn = lianJie("JDBC_db", "sa", "1804123028");
		// 添加sql语句
		String sql = "delete shopping where " + ziName + "='" + name + "'";
		// 执行sql语句
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
		System.out.println("共删除" + i + "条数据");

	}

	// 删除数据的方法的重載
	public static void del(String ziName) {
		// 加载驱动
		Connection conn = lianJie("JDBC_db", "sa", "1804123028");
		// 添加sql语句
		String sql = "delete shopping where 水果名称='" + ziName + "'";
		// 执行sql语句
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
		System.out.println("共删除" + i + "条数据");

	}

	// 修改的方法
	public static void set(double set, String lie) {
		// 加载驱动
		Connection conn = lianJie("JDBC_db", "sa", "1804123028");
		// 添加sql语句
		String sql = "update shopping set 单价=" + set + "  where 水果名称= '" + lie + "'";
		// 执行sql语句
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
		System.out.println("共修改了" + i + "条数据");

	}

	// 修改方法的重载
	public static void set(String ziName, int lie) {
		// 加载驱动
		Connection conn = lianJie("JDBC_db", "sa", "1804123028");
		// 添加sql语句
		String sql = "update shopping set 货物数量=" + lie + " where 水果名称='" + ziName + "'";
		// 执行sql语句
		PreparedStatement pre = null;
		int i = 0;
		try {
			// 执行sql语句
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
		System.out.println("共修改了" + i + "条数据");
	}

	public static void set(String ziName, String name) {
		// 加载驱动
		Connection conn = lianJie("JDBC_db", "sa", "1804123028");
		// 添加sql语句
		String sql = "update shopping set 水果名称='" + ziName + "' where 水果名称='" + name + "' ";
		// 执行sql语句
		PreparedStatement pre = null;
		int i = 0;
		try {
			// 执行sql语句
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
		System.out.println("共修改了" + i + "条数据");
	}

	// 查询方法
	public static ArrayList<Biao> sel() {
		// 加载驱动
		Connection conn = lianJie("JDBC_db", "sa", "1804123028");
		// 添加sql语句
		String sql = "select * from shopping";
		// 声明一个合集对象
		ArrayList<Biao> arr = new ArrayList<Biao>();
		Statement st = null;
		ResultSet res = null;

		try {
			// 执行sql语句预处理对象
			st = conn.createStatement();
			// 执行sql语句
			res = st.executeQuery(sql);
			while (res.next()) {
				Biao b = new Biao();
				b.setId(res.getInt("ID"));
				b.setName(res.getString("水果名称"));
				b.setMoney(res.getFloat("单价"));
				b.setShu(res.getInt("货物数量"));
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

	// 查询的重载方法
	public static ArrayList<Biao> sel(String ziName) {
		// 加载驱动
		Connection conn = lianJie("JDBC_db", "sa", "1804123028");
		// 添加sql语句
		String sql = "select * from shopping where 水果名称='" + ziName + "'";
		// 声明一个合集对象
		ArrayList<Biao> arr = new ArrayList<Biao>();
		Statement st = null;
		ResultSet res = null;
		Biao b = null;
		try {
			// 执行sql语句预处理对象
			st = conn.createStatement();
			// 执行sql语句
			res = st.executeQuery(sql);
			b = new Biao();
			int con = 0;
			while (res.next()) {
				b.setId(res.getInt("ID"));
				b.setName(res.getString("水果名称"));
				b.setMoney(res.getFloat("单价"));
				b.setShu(res.getInt("货物数量"));
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
		// 加载驱动
		Connection conn = lianJie("JDBC_db", "sa", "1804123028");
		// 添加sql语句
		String sql = "select * from shopping where ID=" + ziName + "";
		// 声明一个合集对象
		ArrayList<Biao> arr = new ArrayList<Biao>();
		Statement st = null;
		ResultSet res = null;
		Biao b = null;
		try {
			// 执行sql语句预处理对象
			st = conn.createStatement();
			// 执行sql语句
			res = st.executeQuery(sql);
			b = new Biao();
			int con = 0;
			while (res.next()) {
				b.setId(res.getInt("ID"));
				b.setName(res.getString("水果名称"));
				b.setMoney(res.getFloat("单价"));
				b.setShu(res.getInt("货物数量"));
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
