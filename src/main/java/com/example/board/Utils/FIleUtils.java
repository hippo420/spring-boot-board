package com.example.board.Utils;

import com.example.board.dto.BoardFileDto;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class FIleUtils {
    public List<BoardFileDto> parseIntFileInfo(int board_idx, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception{
        if(ObjectUtils.isEmpty(multipartHttpServletRequest)){
            return null;
        }
        //새로운 파일명생성을 위한 일자정보 획득 및 경로지정/생성
        List<BoardFileDto> fileList = new ArrayList<>();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        ZonedDateTime current = ZonedDateTime.now();
        String path = "images/"+current.format(dateTimeFormatter);

        File file = new File(path);

        if(file.exists()==false) file.mkdirs();

        Iterator<String> iterator = multipartHttpServletRequest.getFileNames();

        String newFilename, originalFileExtension, contentType;
        while(iterator.hasNext()){
            List<MultipartFile> list = multipartHttpServletRequest.getFiles(iterator.next());
            for(MultipartFile multipartFile : list){
                if(multipartFile.isEmpty()==false){
                    contentType= multipartFile.getContentType();
                    if(ObjectUtils.isEmpty(contentType)){
                        break;
                    }else{
                        //확장자 지정
                        if(contentType.contains("image/jpeg"))
                            originalFileExtension = ".jpg";
                        else if(contentType.contains("image/png"))
                            originalFileExtension = ".png";
                        else if(contentType.contains("image/gif"))
                            originalFileExtension = ".gif";
                        else
                        {
                            //TODO
                            //other EXT
                            break;
                        }
                    }

                    //서버에 저장될 파일명 생성 및 저장될 파일 데이터 세팅
                    newFilename = Long.toString(System.nanoTime())+originalFileExtension;
                    BoardFileDto boardFileDto = new BoardFileDto();
                    boardFileDto.setBoard_idx(board_idx);
                    boardFileDto.setFile_size(multipartFile.getSize());
                    boardFileDto.setOriginal_file_name(multipartFile.getOriginalFilename());
                    boardFileDto.setStored_file_path(path+"/"+newFilename);
                    fileList.add(boardFileDto);

                    //업로드된 파일의 새로운 이름을 지정된 경로에 저장
                    file = new File(path+"/"+newFilename);
                    multipartFile.transferTo(file);

                }
            }
        }
        return fileList;
    }
}
