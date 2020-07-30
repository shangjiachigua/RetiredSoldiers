package com.caifu;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.caifu.dto.JxActivityDto;
import com.caifu.dto.JxJournalismDto;
import com.caifu.mapper.JxActivityMapper;
import com.caifu.mapper.JxJournalismMapper;
import com.caifu.pojo.PDictionariesValue;
import com.caifu.service.DataService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tianwenwen
 * @version 1.0.0
 * @ClassName MyTest.java
 * @createTime 2020年07月15日 15:38
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class MyTest {

    @Autowired
    private DataService dataService;

    @Test
    public void test() {
        System.out.println("true = " + true);
    }

    @Test
    public void testadd() {
        String name = "xxx";
        String type = "1";
        try {
            Map<String, Object> map = dataService.addPDictionariesValue(name, type);
            System.out.println("map.get(\"msg\") = " + map.get("msg"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete() {
        dataService.deletePDictionariesValue("d3a15cf5f4f0d65f2fe42875b24ebe44");
    }

    @Test
    public void testSelect() {
        IPage<PDictionariesValue> pDictionariesValueByType = dataService.getPDictionariesValueByType("1", "1", "10");
        List<PDictionariesValue> records = pDictionariesValueByType.getRecords();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", records);

        JSONArray jsonArray = new JSONArray();
        boolean add = jsonArray.add(records);
        System.out.println(jsonArray);

    }

    @Test
    public void testDate() {
        Date date = new Date();
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        System.out.println("format = " + format);
    }

    @Test
    public void testException() {
        try {
            throw new MyException("error", "异常");
        } catch (MyException e) {
            System.out.println("e.getMoli() = " + e.getMoli());
            e.printStackTrace();
        }
    }

    class MyException extends Exception {
        private String moli;

        public MyException() {
        }

        public MyException(String message, String moli) {
            super(message);
            this.moli = moli;
        }

        public String getMoli() {
            return moli;
        }

        public void setMoli(String moli) {
            this.moli = moli;
        }
    }

    @Test
    public void testFile() {
        File file = new File("d:\\sdlf");
        System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());

        File file1 = new File("fiel.txt");
        System.out.println("file1.getAbsolutePath() = " + file1.getAbsolutePath());

        File file2 = new File(file, "file.txt");
        System.out.println("file2.getAbsolutePath() = " + file2.getAbsolutePath());

        boolean exists = file1.exists();
        System.out.println("exists = " + exists);

        boolean directory = file1.isDirectory();
        System.out.println("directory = " + directory);

        boolean file3 = file1.isFile();
        System.out.println("file3 = " + file3);

        String parent = file2.getParent();
        System.out.println("parent = " + parent);
        File parentFile = file2.getParentFile();
        System.out.println("parentFile = " + parentFile);

    }

    @Test
    public void testFile2() {
        File file = new File("C:\\Users\\76950\\Desktop\\testfile\\test");
        if (!file.exists()) {
            file.mkdir();
        }

        File file1 = new File(file, "\\file\\file2");
        if (!file1.exists()) {
            file1.mkdirs();
        }

        File file2 = new File(file, "\\file2\\file2");

        System.out.println("file2.getParentFile() = " + file2.getParentFile());
        if (!file2.getParentFile().exists()) {
            file2.mkdirs();
        }

    }

    @Test
    public void testStrem() {
        File file = new File("C:\\Users\\76950\\Desktop\\testfile\\test1\\lol.txt");
        File parentFile = file.getParentFile();
        System.out.println("parentFile = " + parentFile);
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }

    }


    @Test
    public void testStrem2() {
        File file = new File("C:\\Users\\76950\\Desktop\\testfile\\test2\\lol.txt");
        File parentFile = file.getParentFile();
        System.out.println("parentFile = " + parentFile);
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }

        byte[] data = {88, 89};
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(data);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testFileStream() throws Exception {
        File file = new File("C:\\Users\\76950\\Desktop\\testfile\\test2\\lol.txt");
        byte[] bytes = new byte[512];
        FileInputStream fileInputStream = new FileInputStream(file);
        int i = 0;
        File file1 = null;
        FileOutputStream fileOutputStream = null;
        int read = fileInputStream.read(bytes);
        while (read != -1) {
            file1 = new File("C:\\Users\\76950\\Desktop\\testfile\\test2\\lol_" + i + ".txt");
            fileOutputStream = new FileOutputStream(file1);
            fileOutputStream.write(bytes);
            read = fileInputStream.read(bytes);
            i += 1;
        }

        fileInputStream.close();
        fileOutputStream.close();
    }

    @Autowired
    private JxJournalismMapper jxJournalismMapper;

    @Test
    public void testWW() {
        HashMap<String, Object> hashMap = new HashMap<>();
        List<JxJournalismDto> jxJournalismDtos = jxJournalismMapper.selectJxJournalismList(hashMap);
        for (JxJournalismDto jxJournalismDto : jxJournalismDtos) {
            System.out.println("jxJournalismDto = " + jxJournalismDto);
        }
    }

    @Autowired
    private JxActivityMapper jxActivityMapper;

    @Test
    public void testWW2() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("title", "test");
        List<JxActivityDto> jxActivityDtos = jxActivityMapper.selectActivityList(hashMap);
        for (JxActivityDto jxActivityDto : jxActivityDtos) {
            System.out.println("jxActivityDto = " + jxActivityDto);
        }
    }

}
