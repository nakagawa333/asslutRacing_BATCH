package com.assolutoRacing.batch.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.assolutoRacing.batch.mapper.TempUserMapper;

@Component
public class TempUserConfig {
	@Autowired
	TempUserMapper tempUserMapper;
	/**
	 * 1日毎に作成日時が1日以降の仮ユーザーを削除する。
	 * @throws Exception 
	 */
//	@Scheduled(cron = "${tempUser.daily}")
	@Scheduled(fixedRate = 5000)
	@Transactional
	public void deleteOfAfterOneDay() throws Exception {
		try {
			//作成日時が1日以後のデータを削除する
			tempUserMapper.deleteOfAfterOneDay();
		} catch(Exception e) {
			throw new Exception("仮ユーザーの削除に失敗しました");
		}
		
		try {
			//登録済ユーザーを削除する
			tempUserMapper.deleteOfRegistered();
		} catch(Exception e) {
			throw new Exception("仮ユーザーの削除に失敗しました");
		}
	}
}
