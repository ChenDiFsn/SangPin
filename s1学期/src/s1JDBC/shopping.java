package s1JDBC;

import java.util.ArrayList;
import java.util.Scanner;

public class shopping {
	public static void main(String[] args) {
		// JdbcFangFaJi.ChuangBiao();
		JdbcFangFaJi j1 = new JdbcFangFaJi();
		while (true) {
			System.out.println("��ӭ��������ˮ����  ��ִ�����²���");
			System.out.println("1:��ѯˮ�������Ʒ��");
			System.out.println("2:���ˮ������Ʒ��");
			System.out.println("3:�޸���Ʒ���ڵ�ˮ�����ƻ򵥼�");
			System.out.println("4:ɾ����Ʒ���ϵ���Ʒ");
			System.out.println("5:�˳��̳�");
			Scanner input = new Scanner(System.in);
			String str = input.next();
			if (str.equals("1")) {// ��ѯ�ķ���
				boolean f = true;
				while (f) {
					System.out.println("1:��ѯ������Ʒ��Ϣ  2����ѯ������Ʒ��  3:������һ��");
					String xuan = input.next();
					if (xuan.equals("1")) {// ��ѯ������Ʒ
						while (true) {
							System.out.println("Ҫ��ѯ�ķ�ʽ 1:��Ʒ����    2����ƷID  3:������һ��");
							String xuan1 = input.next();// ѡ��ʽ
							if (xuan1.equals("1")) {
								System.out.println("��������Ʒ����");
								String ziName = input.next();// ��Ʒ����
								ArrayList<Biao> arr = j1.sel(ziName);
								for (Biao i : arr) {
									System.out.println(
											i.getId() + "\t" + i.getName() + "\t" + i.getMoney() + "\t" + i.getShu());
								}
								while (true) {
									System.out.println("�Ƿ���������Ʒ  1����  2����");
									String xuan2 = input.next();
									if (xuan2.equals("1")) {
										break;
									} else if (xuan2.equals("2")) {
										f = false;
										break;
									} else {
										System.out.println("��������");
									}
								}
							} else if (xuan1.equals("2")) {// ����id����ѯ��Ʒ�ķ���
								System.out.println("��������ƷID");
								int ID = input.nextInt();
								ArrayList<Biao> arr = j1.sel(ID);
								for (Biao i : arr) {// ѭ����ӡ���ҵ�������
									System.out.println(
											i.getId() + "\t" + i.getName() + "\t" + i.getMoney() + "\t" + i.getShu());
								}
								while (true) {
									System.out.println("�Ƿ���������Ʒ  1����  2����");
									String xuan2 = input.next();
									if (xuan2.equals("1")) {
										break;
									} else if (xuan2.equals("2")) {
										f = false;
										break;
									} else {
										System.out.println("��������");
									}
								}
							} else if (xuan1.equals("3")) {// �˳�
								break;
							} else {
								System.out.println("��������");
							}
						}
					} else if (xuan.equals("2")) {// ������ݵķ���
						ArrayList<Biao> arr = j1.sel();
						for (Biao i : arr) {// ѭ����ӡ���ҵ�����
							System.out
									.println(i.getId() + "\t" + i.getName() + "\t" + i.getMoney() + "\t" + i.getShu());
						}

					} else if (xuan.equals("3")) {
						break;
					}
				}
			} else if (str.equals("2")) {// �����Ʒ�ķ���
				boolean f = true;
				while (f) {
					System.out.println("��������Ҫ��ӵ���Ʒ��Ϣ");
					System.out.println("��������Ʒ����");
					String name = input.next();
					System.out.println("��Ʒ����");
					double money = input.nextDouble();
					System.out.println("��Ʒ����");
					int shu = input.nextInt();
					j1.add(name, money, shu);
					while (true) {
						System.out.println("�Ƿ���������Ʒ  1����  2����");
						String xuan = input.next();
						if (xuan.equals("1")) {
							break;
						} else if (xuan.equals("2")) {
							f = false;
							break;
						} else {
							System.out.println("��������");
						}
					}
				}
			} else if (str.equals("3")) {// �޸���Ʒ��Ϣ�ķ���
				boolean f = true;
				while (f) {
					System.out.println("��ѡ����Ҫ�޸ĵ�����   1���޸ļ۸�   2���޸�����  3���޸���Ʒ����  4:������һ��");
					String xuan = input.next();// ѡ���޸ĵķ�ʽ
					if (xuan.equals("1")) {// �޸���Ʒ�ļ۸�
						System.out.println("�����뱻�޸ĵ���Ʒ����");
						String name = input.next();
						System.out.println("������Ҫ�޸ĵļ۸�");
						double money = input.nextDouble();
						j1.set(money, name);
						while (true) {
							System.out.println("�Ƿ�����޸���Ʒ��Ϣ  1:�� 2����");
							String xuan1 = input.next();
							if (xuan1.equals("1")) {
								break;
							} else if (xuan1.equals("2")) {
								f = false;
								break;
							} else {
								System.out.println("��������");
							}
						}
					} else if (xuan.equals("2")) {// �޸���Ʒ������
						System.out.println("�����뱻�޸ĵ���Ʒ����");
						String name = input.next();
						System.out.println("������Ҫ�޸ĵ���Ʒ����");
						int shu = input.nextInt();
						j1.set(name, shu);
						while (true) {
							System.out.println("�Ƿ�����޸���Ʒ��Ϣ  1:�� 2����");
							String xuan1 = input.next();
							if (xuan1.equals("1")) {
								break;
							} else if (xuan1.equals("2")) {
								f = false;
								break;
							} else {
								System.out.println("��������");
							}
						}
					} else if (xuan.equals("3")) {// �޸���Ʒ������
						System.out.println("�����뱻�޸ĵ���Ʒ����");
						String name = input.next();
						System.out.println("������Ҫ�޸ĵ���Ʒ����");
						String zName = input.next();
						j1.set(zName, name);
						while (true) {
							System.out.println("�Ƿ�����޸���Ʒ��Ϣ  1:�� 2����");
							String xuan1 = input.next();
							if (xuan1.equals("1")) {
								break;
							} else if (xuan1.equals("2")) {
								f = false;
								break;
							} else {
								System.out.println("��������");
							}
						}
					} else if (xuan.equals("4")) {
						break;
					} else {
						System.out.println("��������");
					}
				}
			} else if (str.equals("4")) {// ɾ����Ʒ��Ϣ����
				boolean f = true;
				while (f) {
					System.out.println("������Ҫɾ������Ʒ����");
					String name = input.next();
					j1.del(name);
					while (true) {
						System.out.println("�Ƿ����ɾ����Ʒ  1����   2����");
						String xuan = input.next();
						if (xuan.equals("1")) {
							break;
						} else if (xuan.equals("2")) {
							f = false;
							break;
						} else {
							System.out.println("��������");
						}
					}
				}
			} else if (str.equals("5")) {
				System.out.println("�˳��ɹ�");
				break;
			} else {
				System.out.println("��������");
			}
		}
	}
}
