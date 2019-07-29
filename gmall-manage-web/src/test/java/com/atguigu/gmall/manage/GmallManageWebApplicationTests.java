package com.atguigu.gmall.manage;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallManageWebApplicationTests {

	@Test
	public void contextLoads() throws IOException, MyException {

		String path = GmallManageWebApplicationTests.class.getClass().getResource("/tracker.conf").getPath();
		ClientGlobal.init(path);

		TrackerClient trackerClient = new TrackerClient();
		TrackerServer trackerServer = trackerClient.getConnection();

		StorageClient storageClient = new StorageClient(trackerServer, null);

		String orginalFileName = "d://a.jpg";
		String[] upload_file = storageClient.upload_file(orginalFileName, "jpg	", null);

		String url = "http://192.168.248.100";
		for (int i = 0; i < upload_file.length; i++) {
			url = url +"/"+ upload_file[i];
		}
		System.out.println(url);
	}

}
