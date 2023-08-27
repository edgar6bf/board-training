package site.board.boardtraining.domain.article.dto.business;

import site.board.boardtraining.domain.article.entity.Article;
import site.board.boardtraining.domain.member.dto.business.MemberDto;

import java.time.LocalDateTime;
import java.util.Set;

public record ArticleDto(
        Long articleId,
        String title,
        String content,
        String thumbnailImageUrl,
        Set<String> hashtags,
        MemberDto member,
        LocalDateTime createdAt
) {
    public static ArticleDto of(
            Long articleId,
            String title,
            String content,
            String thumbnailImageUrl,
            Set<String> hashtags,
            MemberDto member,
            LocalDateTime createdAt
    ) {
        return new ArticleDto(
                articleId,
                title,
                content,
                thumbnailImageUrl,
                hashtags,
                member,
                createdAt
        );
    }

    public static ArticleDto from(
            Article article,
            Set<String> hashtags
    ) {
        return new ArticleDto(
                article.getId(),
                article.getTitle(),
                article.getContent(),
                article.getThumbnailImageUrl(),
                hashtags,
                MemberDto.from(article.getMember()),
                article.getCreatedAt()
        );
    }
}