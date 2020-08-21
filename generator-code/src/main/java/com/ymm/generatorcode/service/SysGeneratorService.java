
package com.ymm.generatorcode.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ymm.generatorcode.dao.GeneratorDao;
import com.ymm.generatorcode.utils.GenUtils;
import com.ymm.generatorcode.utils.PageUtils;
import com.ymm.generatorcode.utils.Query;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * 代码生成器
 *
 * @author Mark sunlightcs@gmail.com
 */
@Service
public class SysGeneratorService {
	@Autowired
	private GeneratorDao generatorDao;

	public static List<String> getEliminateColumnName(){
		List<String> eliminateColumnName = new ArrayList<>();
		eliminateColumnName.add("created_user");
		eliminateColumnName.add("created_date");
		eliminateColumnName.add("updated_user");
		eliminateColumnName.add("updated_date");
		eliminateColumnName.add("del_flag");
		return eliminateColumnName;
	}

	public PageUtils queryList(Query query) {
		Page<?> page = PageHelper.startPage(query.getPage(), query.getLimit());
		List<Map<String, Object>> list = generatorDao.queryList(query);

		return new PageUtils(list, (int)page.getTotal(), query.getLimit(), query.getPage());
	}

	public Map<String, String> queryTable(String tableName) {
		return generatorDao.queryTable(tableName);
	}

	public List<Map<String, String>> queryColumns(String tableName) {
		return generatorDao.queryColumns(tableName);
	}

	public byte[] generatorCode(String[] tableNames) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ZipOutputStream zip = new ZipOutputStream(outputStream);

		// 获取剔除字段
		List<String> eliminateColumnNameList = getEliminateColumnName();

		for(String tableName : tableNames){
			//查询表信息
			Map<String, String> table = queryTable(tableName);
			//查询列信息
			List<Map<String, String>> columns = queryColumns(tableName);
//			// 剔除之后的所有字段
//			List<Map<String, String>> columnsNew = new ArrayList<>();
//			for (Map<String, String> map: columns) {
//				if (eliminateColumnNameList.indexOf(map.get("columnName")) > -1){
//					continue;
//				}
//				columnsNew.add(map);
//			}
			//生成代码
			GenUtils.generatorCode(table, columns, zip);
		}
		IOUtils.closeQuietly(zip);
		return outputStream.toByteArray();
	}
}
