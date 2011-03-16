package com.olivelabs.gridcomputing.common.result;

import java.util.List;

public interface Result {
	public Object getResult(List<SubResult> results);
}
