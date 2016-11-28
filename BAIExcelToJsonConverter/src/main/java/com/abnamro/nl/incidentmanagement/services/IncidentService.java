package com.abnamro.nl.incidentmanagement.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.abnamro.nl.incidentmanagement.dto.Incident;

public class IncidentService {

	public List<Incident> readFromExcel() throws IOException {
		List<Incident> incidents = new ArrayList<Incident>();
		Incident incident = null;

		// statred reading excel
		XSSFRow row = null;
		FileInputStream fis = new FileInputStream(
				"F:\\workspace_mars\\BAIExcelToJsonConverter\\src\\main\\resources\\Incident.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowCount = 0;
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			if (rowCount == 0) {
				rowIterator.next();
				rowCount++;
				continue;
			}
			incident = new Incident();
			int count = 0;
			row = (XSSFRow) rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				if (count == 0) {
					Cell cell = cellIterator.next();
					incident.setNumber(cell.getStringCellValue());
					count++;
				} else if (count == 1) {
					Cell cell = cellIterator.next();
					incident.setEnvironment(cell.getStringCellValue());
					count++;
				} else if (count == 2) {
					Cell cell = cellIterator.next();
					incident.setProject(cell.getStringCellValue());
					count++;
				}
			}
			incidents.add(incident);
		}
		fis.close();

		return incidents;
	}

}
