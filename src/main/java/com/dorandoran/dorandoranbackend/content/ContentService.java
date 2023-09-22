package com.dorandoran.dorandoranbackend.content;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import com.dorandoran.dorandoranbackend.config.S3Config;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ContentService {

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;

    private String folderName = "content/";

    private final ContentRepository contentRepository;

    private final AmazonS3 s3;


    private String createFileName(String fileName) {
        return UUID.randomUUID().toString().concat(getFileExtension(fileName));
    }

    public List<List<String>> uploadFile(List<MultipartFile> multipartFiles) {
        List<List<String>> dataListResult = new ArrayList<>();

        multipartFiles.forEach(file -> {
            List<String> dataList = new ArrayList<>();

            String fileName = createFileName(file.getOriginalFilename());
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(file.getSize());
            objectMetadata.setContentType(file.getContentType());

            try (InputStream inputStream = file.getInputStream()) {
                AccessControlList acl = s3.getBucketAcl(bucketName);
                acl.grantPermission(GroupGrantee.AllUsers, Permission.Read);
                s3.setBucketAcl(bucketName, acl);
                s3.putObject(new PutObjectRequest(bucketName, folderName + fileName, inputStream, objectMetadata)
                        .withCannedAcl(CannedAccessControlList.PublicRead));
            } catch (IOException e) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "파일 업로드에 실패하였습니다.");
            }

            dataList.add(file.getOriginalFilename());
            dataList.add(String.valueOf(file.getSize()));
            dataList.add(s3.getUrl(bucketName, folderName + fileName).toString());

            dataListResult.add(dataList);
        });

        return dataListResult;
    }


    private String getFileExtension(String fileName) {
        try {
            return fileName.substring(fileName.lastIndexOf("."));
        } catch (StringIndexOutOfBoundsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "잘못된 형식의 파일(" + fileName + ") 입니다.");
        }
    }

    public Long saveContent(Content content) {
        contentRepository.save(content);
        return content.getContentId();
    }

    public void removeContent(Long id) {
        contentRepository.remove(id);
    }

    public Content findContentById(Long id) {
        return contentRepository.findById(id);
    }

    public List<Content> findAllContents() {
        return contentRepository.findAllContents();
    }
}
