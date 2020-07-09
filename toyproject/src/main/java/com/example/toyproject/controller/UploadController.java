
package com.example.toyproject.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.toyproject.model.Board;
import com.example.toyproject.model.FileInfo;
import com.example.toyproject.repository.FileInfoRepository;





@Controller
public class UploadController {
	@GetMapping("/upload")
	public String upload() {
		return "upload";
	}
	
	@Autowired FileInfoRepository fr;
	
	
	@PostMapping("/upload")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public void uploadPost(MultipartHttpServletRequest mRequest, @ModelAttribute Board board) {
		System.out.println("@#%@#%" + mRequest);
		System.out.println(board);
		List<MultipartFile> mFiles = mRequest.getFiles("file");
		for (int i = 0; i < mFiles.size(); i++) {
			MultipartFile mFile = mFiles.get(i);

			String oName = mFile.getOriginalFilename();

			int idx = oName.lastIndexOf(".");
			String name = oName.substring(0, idx);
			String ext = oName.substring(idx);

			if (!ext.toLowerCase().equals(".jpg") && 
					!ext.toLowerCase().equals(".gif")&& 
					!ext.toLowerCase().equals(".png")) {
				continue;
			}

			File file = new File("c:/dev/" + oName);

			String saveName = "";

			if (file.exists()) {
				saveName = name + "_" + System.currentTimeMillis() + ext;
			} else {
				saveName = oName;
			}

			try {
				mFile.transferTo(new File("c:/dev/" + saveName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			   
	     
	         FileInfo fileinfo = new FileInfo();
	         fileinfo.setFileName(saveName);
	         fileinfo.setFileOriginalName(oName);
	         fileinfo.setFileUrl("c:/dev/" + saveName);
	         fr.save(fileinfo);
	        
		
		}
	}

}



//@RequestMapping(value = "/multipartUpload.do", method = RequestMethod.POST)
//public @ResponseBody Map<String, Object> multipartUpload(MultipartHttpServletRequest request) throws Exception {
//    
//    List<MultipartFile> fileList = new ArrayList<MultipartFile>();
//    
//    // input file 에 아무것도 없을 경우 (파일을 업로드 하지 않았을 때 처리)
//    if(request.getFiles("file").get(0).getSize() != 0){
//    	fileList = request.getFiles("file");
//    }
//        
//    String path = application.getRealPath("[경로]");
//    
//    File fileDir = new File(path);
//    
//    if (!fileDir.exists()) {
//    	fileDir.mkdirs();
//	}
//    
//    long time = System.currentTimeMillis();
//    
//    for (MultipartFile mf : fileList) {
//    
//    	String originFileName = mf.getOriginalFilename(); // 원본 파일 명
//        String saveFileName = String.format("%d_%s", time, originFileName);
//        
//        try {
//        	// 파일생성
//            mf.transferTo(new File(path, saveFileName));    		
//        } catch (Exception e) {
//        	e.printStackTrace();
//        }
//     }
//}
 


