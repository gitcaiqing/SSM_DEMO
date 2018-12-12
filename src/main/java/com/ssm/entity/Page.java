package com.ssm.entity;

public class Page<T> {
	//页码
	private Integer page = 1;
	//数据记录总数
	private Integer total; 
	//数据记录
	private T rows;
	
	private int start = 0;
	//添加额外属性
	private int pageSize = 5;
	//排序字段
	private String sort = "id";
	//排序方向  desc|asc
	private String order = "desc";
	
	public Integer getPage() {
		if(start == 0) {
			return page;
		}
		return start/pageSize + 1;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public T getRows() {
		return rows;
	}
	public void setRows(T rows) {
		this.rows = rows;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public Page() {
		super();
	}
	public Page(Integer page, Integer total, T rows) {
		super();
		this.page = page;
		this.total = total;
		this.rows = rows;
	}
	public Page(Integer page, Integer total, T rows, int pageSize, String sort, String order) {
		super();
		this.page = page;
		this.total = total;
		this.rows = rows;
		this.pageSize = pageSize;
		this.sort = sort;
		this.order = order;
	}
	@Override
	public String toString() {
		return "Page [page=" + page + ", total=" + total + ", rows=" + rows + ", start=" + start + ", pageSize="
				+ pageSize + ", sort=" + sort + ", order=" + order + "]";
	}
	
}
