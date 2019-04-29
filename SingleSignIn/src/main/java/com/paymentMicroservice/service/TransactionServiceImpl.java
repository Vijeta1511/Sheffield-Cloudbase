
package com.paymentMicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymentMicroservice.dao.BaseDAO;
import com.paymentMicroservice.dao.TransactionDAO;
import com.paymentMicroservice.domain.Transaction;
import com.paymentMicroservice.rm.TransactionRowMapper;

/**
 * @author vijetaagrawal
 *
 */

@Service
public class TransactionServiceImpl extends BaseDAO implements TransactionService {
	
	@Autowired
	private TransactionDAO transactionDAO;

	@Override
	public void newTransaction(Transaction t) {
		transactionDAO.save(t);
	}

	@Override
	public List viewAllTransactions(Integer UserId) {
		String sql = "SELECT trans_id FROM transaction WHERE userId =?"
				+ "UNION"
				+ "SELECT app.name FROM transaction t INNER JOIN application app"
				+ "ON app.app_id = t.appId WHERE userId =?";
		return getJdbcTemplate().query(sql, new TransactionRowMapper(), UserId);
		
	}

}
