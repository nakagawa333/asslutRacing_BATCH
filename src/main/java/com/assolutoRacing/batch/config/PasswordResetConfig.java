package com.assolutoRacing.batch.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.assolutoRacing.batch.mapper.PasswordResetMapper;

@Component
public class PasswordResetConfig {
	@Autowired
	PasswordResetMapper passwordResetMapper;
	
	private final String passwordResetDaily = "${passwordReset.daily}";
	
	/**
	 * 1日毎に作成日時が1日以降のパスワードリセットデータを削除する。
	 * @throws Exception 
	 */
	@Scheduled(cron = passwordResetDaily)
	@Transactional
	public void deleteOfAfterOneDay() throws Exception {
		try {
			passwordResetMapper.deleteOfAfterOneDay();
		} catch(Exception e) {
			throw new Exception("パスワードリセットの削除に失敗しました");
		}
	}
}
