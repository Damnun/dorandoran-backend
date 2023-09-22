package com.dorandoran.dorandoranbackend.farmContentMap;

import com.dorandoran.dorandoranbackend.content.Content;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FarmContentMapDTO {
    private Long farmId;
    private String contentUrl;
}
