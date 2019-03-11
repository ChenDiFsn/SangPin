package s1JDBC;

import java.util.ArrayList;
import java.util.Scanner;

public class shopping {
	public static void main(String[] args) {
		// JdbcFangFaJi.ChuangBiao();
		JdbcFangFaJi j1 = new JdbcFangFaJi();
		while (true) {
			System.out.println("欢迎来到九云水果店  请执行以下操作");
			System.out.println("1:查询水果店的商品表");
			System.out.println("2:添加水果到商品表");
			System.out.println("3:修改商品表内的水果名称或单价");
			System.out.println("4:删除商品表上的商品");
			System.out.println("5:退出商城");
			Scanner input = new Scanner(System.in);
			String str = input.next();
			if (str.equals("1")) {// 查询的方法
				boolean f = true;
				while (f) {
					System.out.println("1:查询单个商品信息  2：查询整个商品表  3:返回上一步");
					String xuan = input.next();
					if (xuan.equals("1")) {// 查询单个商品
						while (true) {
							System.out.println("要查询的方式 1:商品名称    2：商品ID  3:返回上一步");
							String xuan1 = input.next();// 选择方式
							if (xuan1.equals("1")) {
								System.out.println("请输入商品名称");
								String ziName = input.next();// 商品名称
								ArrayList<Biao> arr = j1.sel(ziName);
								for (Biao i : arr) {
									System.out.println(
											i.getId() + "\t" + i.getName() + "\t" + i.getMoney() + "\t" + i.getShu());
								}
								while (true) {
									System.out.println("是否继续添加商品  1：是  2：否");
									String xuan2 = input.next();
									if (xuan2.equals("1")) {
										break;
									} else if (xuan2.equals("2")) {
										f = false;
										break;
									} else {
										System.out.println("操作错误");
									}
								}
							} else if (xuan1.equals("2")) {// 根据id来查询商品的方法
								System.out.println("请输入商品ID");
								int ID = input.nextInt();
								ArrayList<Biao> arr = j1.sel(ID);
								for (Biao i : arr) {// 循环打印查找到的数据
									System.out.println(
											i.getId() + "\t" + i.getName() + "\t" + i.getMoney() + "\t" + i.getShu());
								}
								while (true) {
									System.out.println("是否继续添加商品  1：是  2：否");
									String xuan2 = input.next();
									if (xuan2.equals("1")) {
										break;
									} else if (xuan2.equals("2")) {
										f = false;
										break;
									} else {
										System.out.println("操作错误");
									}
								}
							} else if (xuan1.equals("3")) {// 退出
								break;
							} else {
								System.out.println("操作错误");
							}
						}
					} else if (xuan.equals("2")) {// 添加数据的方法
						ArrayList<Biao> arr = j1.sel();
						for (Biao i : arr) {// 循环打印查找的数据
							System.out
									.println(i.getId() + "\t" + i.getName() + "\t" + i.getMoney() + "\t" + i.getShu());
						}

					} else if (xuan.equals("3")) {
						break;
					}
				}
			} else if (str.equals("2")) {// 添加商品的方法
				boolean f = true;
				while (f) {
					System.out.println("请输入您要添加的商品信息");
					System.out.println("请输入商品名称");
					String name = input.next();
					System.out.println("商品单价");
					double money = input.nextDouble();
					System.out.println("商品数量");
					int shu = input.nextInt();
					j1.add(name, money, shu);
					while (true) {
						System.out.println("是否继续添加商品  1：是  2：否");
						String xuan = input.next();
						if (xuan.equals("1")) {
							break;
						} else if (xuan.equals("2")) {
							f = false;
							break;
						} else {
							System.out.println("操作错误");
						}
					}
				}
			} else if (str.equals("3")) {// 修改商品信息的方法
				boolean f = true;
				while (f) {
					System.out.println("请选择您要修改的类型   1：修改价格   2：修改数量  3：修改商品名称  4:返回上一步");
					String xuan = input.next();// 选择修改的方式
					if (xuan.equals("1")) {// 修改商品的价格
						System.out.println("请输入被修改的商品名称");
						String name = input.next();
						System.out.println("请输入要修改的价格");
						double money = input.nextDouble();
						j1.set(money, name);
						while (true) {
							System.out.println("是否继续修改商品信息  1:是 2：否");
							String xuan1 = input.next();
							if (xuan1.equals("1")) {
								break;
							} else if (xuan1.equals("2")) {
								f = false;
								break;
							} else {
								System.out.println("操作错误");
							}
						}
					} else if (xuan.equals("2")) {// 修改商品的数量
						System.out.println("请输入被修改的商品名称");
						String name = input.next();
						System.out.println("请输入要修改的商品数量");
						int shu = input.nextInt();
						j1.set(name, shu);
						while (true) {
							System.out.println("是否继续修改商品信息  1:是 2：否");
							String xuan1 = input.next();
							if (xuan1.equals("1")) {
								break;
							} else if (xuan1.equals("2")) {
								f = false;
								break;
							} else {
								System.out.println("操作错误");
							}
						}
					} else if (xuan.equals("3")) {// 修改商品的名称
						System.out.println("请输入被修改的商品名称");
						String name = input.next();
						System.out.println("请输入要修改的商品名称");
						String zName = input.next();
						j1.set(zName, name);
						while (true) {
							System.out.println("是否继续修改商品信息  1:是 2：否");
							String xuan1 = input.next();
							if (xuan1.equals("1")) {
								break;
							} else if (xuan1.equals("2")) {
								f = false;
								break;
							} else {
								System.out.println("操作错误");
							}
						}
					} else if (xuan.equals("4")) {
						break;
					} else {
						System.out.println("操作错误");
					}
				}
			} else if (str.equals("4")) {// 删除商品信息方法
				boolean f = true;
				while (f) {
					System.out.println("请输入要删除的商品名称");
					String name = input.next();
					j1.del(name);
					while (true) {
						System.out.println("是否继续删除商品  1：是   2：否");
						String xuan = input.next();
						if (xuan.equals("1")) {
							break;
						} else if (xuan.equals("2")) {
							f = false;
							break;
						} else {
							System.out.println("操作错误");
						}
					}
				}
			} else if (str.equals("5")) {
				System.out.println("退出成功");
				break;
			} else {
				System.out.println("操作错误");
			}
		}
	}
}
