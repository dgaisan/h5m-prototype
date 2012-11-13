package com.onlymega.dgaisan.html5maker.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.onlymega.dgaisan.html5maker.common.CommonData;
import com.onlymega.dgaisan.html5maker.dao.MembershipDao;
import com.onlymega.dgaisan.html5maker.model.Membership;
import com.onlymega.dgaisan.html5maker.model.RegistrationConfirmation;
import com.onlymega.dgaisan.html5maker.utils.HibernateUtil;

/**
 * Default implementation of {@link MembershipDao}.
 * 
 * @author Dmitri Gaisan
 */
public class MembershipDaoImpl implements MembershipDao {

	public List<Membership> getAvailableMemberships() throws Exception {
		List<Membership> ret = new ArrayList<Membership>();
		
		ret.add(new Membership(1, CommonData.FREE_MEMBERSHIP, "", 0.0));
		ret.add(new Membership(2, "Plus", "", 4.99));
		ret.add(new Membership(3, "Premium", "", 9.49));
		ret.add(new Membership(3, "Ultimate", "", 18.99));
		
		return ret;
	}

	public void saveRegistrationConfirmationCode(RegistrationConfirmation reg) throws HibernateException {
		Session session = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.getTransaction().begin();
			session.save(reg);
			session.getTransaction().commit();
		} catch (HibernateException ex) {
			// log exception
			throw ex;
		} finally {
			if (session != null && session.isOpen()) {
				session.flush();
				session.close();
			}
		}
	}

	public RegistrationConfirmation getRegisterationConfirmationByCode(
			String code) throws HibernateException {
		Session session = null;
		RegistrationConfirmation reg = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			reg = (RegistrationConfirmation) session.createQuery("from RegistrationConfirmation r where r.confirmationCode = ?")
				.setString(0, code).uniqueResult();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		
		return reg;
	}

	public void removeRegistrationConfirmationentry(RegistrationConfirmation reg)
			throws HibernateException {
		Session session = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.getTransaction().begin();
			session.delete(reg);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			if (session != null && session.isOpen()) {
				session.flush();
				session.close();
			}
		}
		
	}

}
