package com.cqrs.query.query.handler;

import com.cqrs.query.query.GetAllProductsQuery;

import java.util.List;

public interface IGetAllProductsQueryHandler {
    List<GetAllProductsQuery> handle();
}
