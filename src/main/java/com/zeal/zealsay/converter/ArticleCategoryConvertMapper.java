package com.zeal.zealsay.converter;

import com.zeal.zealsay.dto.request.*;
import com.zeal.zealsay.dto.response.ArticleCategoryResponse;
import com.zeal.zealsay.entity.ArticleCategory;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * role相关转换器.
 *
 * @author  zhanglei
 * @date 2018/11/15  5:43 PM
 */
@Mapper(componentModel = "spring")
public interface ArticleCategoryConvertMapper {

  ArticleCategoryResponse toArticleCategoryResponse(ArticleCategory articleCategory);

  List<ArticleCategoryResponse> toArticleCategoryResponseList(List<ArticleCategory> articleCategorys);

  ArticleCategory toArticleCategory(ArticleCategoryAddRequest articleCategoryAddRequest);

  ArticleCategory toArticleCategory(ArticleCategoryUpdateRequest articleCategoryUpdateRequest);

  ArticleCategory toArticleCategory(ArticleCategoryPageRequest articleCategoryPageRequest);

}
