package com.prerna.bfhl.service;

import com.prerna.bfhl.dto.BfhlRequest;
import com.prerna.bfhl.dto.BfhlResponse;

public interface BfhlService {
    BfhlResponse processData(BfhlRequest request);
}
