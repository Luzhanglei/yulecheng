package com.yulecheng.util;

import java.util.List;

public class Page<E>
{
  private Long pageNumber = Long.valueOf(1L);
  private Long pageSize = Long.valueOf(10L);
  private Long totalPages = Long.valueOf(0L);
  private Long totalRows = Long.valueOf(0L);
  private List<E> result;
  
  public Long getPageNumber()
  {
    if (this.pageNumber.longValue() <= 1L) {
      return this.pageNumber = Long.valueOf(1L);
    }
    if (this.pageNumber.longValue() >= this.totalPages.longValue()) {
      return this.pageNumber = this.totalPages;
    }
    return this.pageNumber;
  }
  
  public void setPageNumber(Long pageNumber)
  {
    this.pageNumber = pageNumber;
  }
  
  public Long getPageSize()
  {
    return this.pageSize;
  }
  
  public void setPageSize(Long pageSize)
  {
    this.pageSize = pageSize;
  }
  
  public Long getTotalPages()
  {
    if (this.pageSize.longValue() != 0L) {
      this.totalPages = Long.valueOf((this.totalRows.longValue() + this.pageSize.longValue() - 1L) / this.pageSize.longValue());
    }
    return this.totalPages;
  }
  
  public void setTotalPages(Long totalPages)
  {
    this.totalPages = totalPages;
  }
  
  public Long getTotalRows()
  {
    return this.totalRows;
  }
  
  public void setTotalRows(Long totalRows)
  {
    this.totalRows = totalRows;
    
    this.totalPages = getTotalPages();
  }
  
  public List<E> getResult()
  {
    return this.result;
  }
  
  public void setResult(List<E> result)
  {
    this.result = result;
  }
}
