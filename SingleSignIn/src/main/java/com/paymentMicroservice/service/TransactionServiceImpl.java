
package com.paymentMicroservice.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymentMicroservice.dao.ApplicationDAO;
import com.paymentMicroservice.dao.BaseDAO;
import com.paymentMicroservice.dao.Peanut_accountDAO;
import com.paymentMicroservice.dao.TransactionDAO;
import com.paymentMicroservice.domain.Application;
import com.paymentMicroservice.domain.Peanut_account;
import com.paymentMicroservice.domain.Transaction;
import com.paymentMicroservice.rm.ApplicationRowMapper;
import com.paymentMicroservice.rm.Peanut_accountRowMapper;
import com.paymentMicroservice.rm.TransactionRowMapper;

/**
 * @author vijetaagrawal
 *
 */

@Service
public class TransactionServiceImpl extends BaseDAO implements TransactionService {
	
	@Autowired
	private TransactionDAO transactionDAO;
	@Autowired
	private Peanut_accountDAO peanut_accountDAO;
	@Autowired
	private ApplicationDAO applicationDAO;

	@Override
	public void newTransaction( String AppName, Integer UserId) {
		Transaction t = new Transaction();
		String PropName = "name";
		String Account = "userId";
		Application a = applicationDAO.findByProperty(PropName, AppName);
		Peanut_account p = peanut_accountDAO.findByProperty(Account, UserId);
        System.out.println(AppName);
		transactionDAO.save( t, p.getAcc_id(), a.getApp_id(), UserId, AppName);
		
		
	}

	@Override
	public List<Transaction> viewAllTransactions(Integer UserId) {
		String sql = "SELECT trans_id, accId, appId, userId, app_name FROM transaction WHERE userId=?";
		return getJdbcTemplate().query(sql, new TransactionRowMapper(), UserId);
		
	}

}
