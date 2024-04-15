package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.NhanVien;
import entity.Phong;

public class Main {
	public static SessionFactory sessionFactory = new MySessionFactory().getSessionFactory();


	public static List<Phong> layDanhSachPhong()  {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<Phong> listPhong;
		String sql = "select * from Phong";
		try {
			tr.begin();
			listPhong = session.createNativeQuery(sql,Phong.class).getResultList();
			tr.commit();
			return listPhong;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
    public static void main(String[] args) {
    System.out.println(layDanhSachPhong());
    }
   

    private static SessionFactory buildSessionFactory() {
        // Implement the logic to build a SessionFactory based on your Hibernate configuration.
        // This often includes building a Configuration object, adding annotated classes, and then building the SessionFactory.
        return new Configuration().configure().buildSessionFactory();
    }
}
