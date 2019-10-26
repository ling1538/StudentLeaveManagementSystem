package com.imooc.util;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.imooc.bean.ApplyForInformation;
import com.imooc.service.QueryService;

/** 
* 创建excel表格
*/
public class ExcelUtil {

	public void print(String l_class) throws IOException, RowsExceededException, WriteException{
		//获取时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日-HH时mm分ss秒-");  
		Calendar calendar=Calendar.getInstance();
		Date date=calendar.getTime();
		String dateStringParse = sdf.format(date);
        //1:创建excel文件
        File file=new File("D://WorkspacesMyEclipse10/StudentLeaveManagementSystem/WebRoot/ReportManagement/"+dateStringParse+"请假信息表.xls");
        file.createNewFile();
        
        //2:创建工作簿
        WritableWorkbook workbook=Workbook.createWorkbook(file);
        //3:创建sheet,设置第二三四..个sheet，依次类推即可
        WritableSheet sheet=workbook.createSheet("信息管理", 0);
        //4：设置titles
        String[] titles={"编号","学生ID","姓名","班级","状态","联系方式","开始时间","结束时间","请假原因"};
        //5:单元格`
        Label label=null;
        //6:给第一行设置列名
        for(int i=0;i<titles.length;i++){
            //x,y,第一行的列名
            label=new Label(i,0,titles[i]);
            //7：添加单元格
            sheet.addCell(label);
        }
        
        QueryService queryleaveMessageForClassList = new QueryService();
        List<ApplyForInformation> list = new ArrayList<ApplyForInformation>();
        list = queryleaveMessageForClassList.queryleaveMessageForClassList(l_class);
		System.out.println("打印数量："+list.size());
        //8：导入数据
        for(int i=1;i<list.size()+1;i++){
        	
        	    //添加编号，行、列和值
                label=new Label(0,i,String.valueOf(list.get(i-1).getL_number()));
                sheet.addCell(label);
                label=new Label(1,i,String.valueOf(list.get(i-1).getID()));
                sheet.addCell(label);
                label=new Label(2,i,list.get(i-1).getL_name());
                sheet.addCell(label);
                label=new Label(3,i,list.get(i-1).getL_class());
                sheet.addCell(label);
                label=new Label(4,i,list.get(i-1).getL_state());
                sheet.addCell(label);
                label=new Label(5,i,list.get(i-1).getL_phone());
                sheet.addCell(label);
                label=new Label(6,i,list.get(i-1).getL_startTime());
                sheet.addCell(label);
                label=new Label(7,i,list.get(i-1).getL_endTime());
                sheet.addCell(label);
                label=new Label(8,i,list.get(i-1).getL_reason());
                sheet.addCell(label);
        }
        
        //写入数据，一定记得写入数据，不然你都开始怀疑世界了，excel里面啥都没有
        workbook.write();
        System.out.println(list.size()+"写入成功");
        //最后一步，关闭工作簿
        workbook.close();
    }
}