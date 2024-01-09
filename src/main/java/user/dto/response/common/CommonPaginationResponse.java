package user.dto.response.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class CommonPaginationResponse {
    private Integer page;
    private Integer limit;
    private Integer totalData;
    private Integer totalPage;
}

