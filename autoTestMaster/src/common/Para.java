package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


@Test
public class Para {

	/**
	 * 
	 * @author yangw
	 * @version 1.00
	 * @project DCE
	 */
	public String[] paraSeting() throws Exception, IOException {

		jxl.Workbook readwb = null;
		InputStream instream = new FileInputStream("/Users/yangwei/Documents/seleniumfile/selenium_cfg.xls");
		readwb = Workbook.getWorkbook(instream);

		// 
		Sheet readsheet = readwb.getSheet(0);
		int rsRows = 5;
		int rsColumns = 1;
		String user = null;
		String pwd = null;
		String group = null;
		String path = null;
		String url = null;
		//i为行，j为列
		for (int i = 0; i < rsRows; i++) {
			for (int j = 0; j < rsColumns; j++) {
				Cell cell = readsheet.getCell(j, i);
				if (i == 0) {

					user = cell.getContents();
					System.out.println("user1=" + user);

				}

				if (i == 1) {
					pwd = cell.getContents();
					// System.out.println("pwd1=" + pwd);
				}
				if (i == 2) {
					group = cell.getContents();
					// System.out.println("group1=" + group);
				}
				if (i == 3) {
					path = cell.getContents();
					// System.out.println("path1=" + path);
				}
				if (i == 4) {
					url = cell.getContents();
					System.out.println("url1=" + url);
				}
				if ("".equals(cell.getContents()) == true) 
					break;
			}
			// System.out.println("");

		}
		readwb.close();
		String[] str = { user, pwd, group, path, url };
		return str;

	}
}
