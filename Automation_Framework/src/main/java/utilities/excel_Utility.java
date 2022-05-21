package utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class excel_Utility {
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static XSSFCell cell;
    private static int totalrowcount;
    public static void setExcelFile(String path,String sheetname) throws IOException {
        try {
            File F = new File(path);
            FileInputStream inputStream = new FileInputStream(F);
            workbook = new XSSFWorkbook(inputStream);
            sheet = workbook.getSheet(sheetname);
        }catch(Exception e)
        {
            System.out.println("e");
        }
    }
    public static int getrowcontains(String testcasename)
    {
        int i=0;
        totalrowcount=sheet.getLastRowNum();
        for(i=1;i<=totalrowcount;i++)
        {
            if(getCelldata(i,0).equalsIgnoreCase(testcasename))
            {
                break;
            }
        }
        return i;
    }
    public static String getCelldata(int rowno, int colno)
    {
        String celldata=null;
       try
       {
           cell=sheet.getRow(rowno).getCell(colno);
           return cell.toString();
       }
       catch(Exception e)
       {
           return "";
       }
    }
    public static int nextTestCaseRowNo(int testcaserow)
    {
        int i=0;
        for(i=testcaserow+1;i<=totalrowcount;i++)
        {
            if(getCelldata(i,0)!="")
            {
                break;
            }
        }
        return i;
    }
    public static Object[][] getExcelTableData(int testcaserow)
    {
        int k=nextTestCaseRowNo(testcaserow);
        int noofcolumns=sheet.getRow(testcaserow).getLastCellNum()-1;
        String[][] test=new String[k-testcaserow][noofcolumns];
        int ci=0;
        while(testcaserow<k)
        {
            int cj=0;
            for(int j=1;j<=noofcolumns;j++,cj++)
            {
                test[ci][cj]=getCelldata(testcaserow,j);

            }
            ci++;
            testcaserow++;
        }
        return test;
    }

}
