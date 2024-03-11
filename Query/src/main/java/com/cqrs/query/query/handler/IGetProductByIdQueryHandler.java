package com.cqrs.query.query.handler;

import com.cqrs.query.query.GetProductByIdQuery;

public interface IGetProductByIdQueryHandler {
    GetProductByIdQuery handle(Long productByIdQuery);
}
