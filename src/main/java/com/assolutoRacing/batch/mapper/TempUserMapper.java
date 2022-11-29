package com.assolutoRacing.batch.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TempUserMapper {
	/**
	 * 作成日時が1日以後のデータを削除する.
	 * @return 削除件数
	 */
	public void deleteOfAfterOneDay();
}
