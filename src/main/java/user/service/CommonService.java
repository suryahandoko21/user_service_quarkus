package user.service;

import user.dto.response.common.CommonPaginationResponse;

public abstract class CommonService {
    public CommonPaginationResponse constructPaginateResponse(Integer page, Integer limit, Integer totalData) {
        Integer totalPage = (totalData / limit) + 1;
        return CommonPaginationResponse.builder().
                page(page).
                limit(limit).
                totalData(totalData).
                totalPage(totalPage).
                build();
    }
}
