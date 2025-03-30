package com.HE182090.mvc.dao.impl;

import com.HE182090.mvc.dao.StaffDAO;
import com.HE182090.mvc.entity.Staff;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
@RequiredArgsConstructor
public class StaffDAOImpl implements StaffDAO {

    private final SessionFactory sessionFactory;

    @Override
    public Staff create(Staff staff) {
        Session session = sessionFactory.openSession();

        try {
            Transaction transaction = session.beginTransaction();
            session.merge(staff);
            transaction.commit();
            session.close();
            return staff;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Staff findById(Long id) {
        Session session = sessionFactory.openSession();

        try {
//            Transaction transaction = session.beginTransaction();
            Staff staff = session.get(Staff.class, id);
//            transaction.commit();
            session.close();
            return staff;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Staff deleteById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Staff f = session.get(Staff.class, id);
            if (f != null) {
                session.remove(f);
                transaction.commit();
                return f;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Staff> getAll() {
        Session session = sessionFactory.openSession();
        String hql = "from Staff ORDER BY name ASC";
        try {
            TypedQuery<Staff> query = session.createQuery(hql, Staff.class);
            List<Staff> staffs = query.getResultList();
            session.close();
            return staffs.isEmpty() ? null : staffs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
