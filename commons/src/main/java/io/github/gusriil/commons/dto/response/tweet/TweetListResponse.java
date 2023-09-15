package io.github.gusriil.commons.dto.response.tweet;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.gusriil.commons.dto.response.user.CommonUserResponse;
import lombok.Data;

@Data
public class TweetListResponse {
    private Long id;
    private String name;
    private String altWallpaper;
    private String wallpaper;
    private CommonUserResponse listOwner;
    private Long membersSize;
    @JsonProperty("isPrivate")
    private boolean isPrivate;
}
