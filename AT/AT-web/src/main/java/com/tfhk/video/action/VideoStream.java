package com.tfhk.video.action;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope(value = "prototype")
@RequestMapping("/video")
public class VideoStream {
	
	private final String FILE_PATH = "D:\\\\Christopher-Naked.mp4";
	
	@RequestMapping(value = "/getVideo", method = RequestMethod.GET)
	public void getVidep(HttpServletResponse respones, HttpServletRequest request) {
		RandomAccessFile raf = null;
		OutputStream os = null;
		String requestRange = request.getHeader("Range");
		respones.setHeader("Accept-Ranges", "bytes");

		if (requestRange != null) {
			respones.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);

			try {
				File file = new File(FILE_PATH);
				raf = new RandomAccessFile(file, "r");
				os = respones.getOutputStream();

				long fileLength = file.length();
				long requestLength = Long.parseLong(requestRange.replaceAll("bytes=", "").replaceAll("-", ""));
				respones.setHeader("Content-Length", new Long(fileLength - requestLength).toString());
				System.out.println(requestLength);
				respones.setHeader("Content-Range",
						"bytes " + requestLength + "-" + (fileLength - 1) + "/" + fileLength);
				respones.setContentType("application/octet-stream");

				byte[] bytes = new byte[10240];
				int read;
				
				if(requestLength == 0) {
					while ((read = raf.read(bytes)) > 0) {
		                os.write(bytes, 0, read);
		            }
				}else {
					raf.seek(requestLength);
		            long toRead = fileLength;

		            while ((read = raf.read(bytes)) > 0) {
		                if ((toRead -= read) > 0) {
		                	os.write(bytes, 0, read);
		                } else {
		                    os.write(bytes, 0, (int) toRead + read);
		                    break;
		                }
		            }
				}

			} catch (IOException e) {
				 e.printStackTrace();
			}finally {
				try {
					os.close();
					raf.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
