package org.example.user.service.recipesService;import org.example.user.component.kgResponseJson.KgResponseJson;import org.springframework.web.multipart.MultipartFile;import javax.servlet.http.HttpServletRequest;public interface RecipesService {    KgResponseJson uploadPic(MultipartFile[] fileList, HttpServletRequest httpServletRequest);}