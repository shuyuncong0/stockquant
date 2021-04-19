package com.taotr.stockquant.commons.result;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class CrhPageResult<T> extends CrhBaseResult implements IPage<T> {

    private static final long serialVersionUID = 8545996863226528798L;

    /**
     * 查询数据列表
     */
    private List<T> records = Collections.emptyList();

    /**
     * 总数
     */
    private long total = 0;
    /**
     * 每页显示条数，默认 10
     */
    private long size = 10;
    
    private int totalPages;
    
    private boolean isFirstPage;
    
    private boolean isLastPage;
    
    private boolean hasPrePage;
    
    private boolean hasNextPage;
    
    private int prePageNum;
    private int nextPageNum;
    
    private Boolean hasBegDotDot;	// 有没有前点点点
	private Boolean hasEndDotDot;	// 有没有后点点点
	private Boolean showFirstPage;	// 是否需要显示第一页
	private Boolean showLastPage;	// 是否需要显示最后一页
    
    private Integer[] numList;		// 滑动页码列表

    /**
     * 当前页
     */
    private long current = 1;

    /**
     * 排序字段信息
     */
    private List<OrderItem> orders = new ArrayList<>();

    /**
     * 自动优化 COUNT SQL
     */
    private boolean optimizeCountSql = true;
    /**
     * 是否进行 count 查询
     */
    private boolean isSearchCount = true;

	/** 当前每页显示数量（原样传出） */
	private long page_size;

	/** 当前页码（原样传出） */
	private long page_num;

	/** 总共记录数 */
	private long total_number;

	private long total_page;

	private boolean has_next;

    public CrhPageResult() {
    }

    /**
     * 分页构造函数
     *
     * @param current 当前页
     * @param size    每页显示条数
     */
    public CrhPageResult(long current, long size) {
        this(current, size, 0);
    }

    public CrhPageResult(long current, long size, long total) {
        this(current, size, total, true);
    }

    public CrhPageResult(long current, long size, boolean isSearchCount) {
        this(current, size, 0, isSearchCount);
    }

    public CrhPageResult(long current, long size, long total, boolean isSearchCount) {
        if (current > 1) {
            this.current = current;
        }
        this.size = size;
        this.page_num = current;
        this.page_size = size;
        this.total = total;
        this.total_number = total;
        this.total_page = getPages();
        this.isSearchCount = isSearchCount;
        calc();
    }

    private void calc() {
		if (total > 0 && size > 0) {
			int count = (int) (total / Long.valueOf(size).intValue());
			if (total % size > 0) {
				count++;
			}
			totalPages = count;
			total_page = count;
		} else {
			totalPages = 0;
			total_page = 0;
		}
		
		// isFirstPage
		isFirstPage = current <= 1;

		// isLastPage
		isLastPage = current >= totalPages;

		// hasPrePage
		hasPrePage = current - 1 >= 1;

		// hasNextPage
		hasNextPage = current + 1 <= totalPages;
		has_next = current + 1 <= totalPages;

		// prePageNum
		if (hasPrePage) {
			prePageNum = Long.valueOf(current).intValue() - 1;
		} else {
			prePageNum = Long.valueOf(current).intValue();
		}

		// nextPageNum
		if (hasNextPage) {
			nextPageNum = Long.valueOf(current).intValue() + 1;
		} else {
			nextPageNum = Long.valueOf(current).intValue();
		}

		numList = generateLinkPageNumbers(Long.valueOf(current).intValue(), totalPages, 5);

		if (numList != null && numList.length > 0) {
			if (numList[0] > 2) {
				hasBegDotDot = true;
			} else {
				hasBegDotDot = false;
			}

			if (numList[numList.length - 1] < totalPages - 1) {
				hasEndDotDot = true;
			} else {
				hasEndDotDot = false;
			}

			if (numList[0] > 1) {
				showFirstPage = true;
			} else {
				showFirstPage = false;
			}

			if (numList[numList.length - 1] < totalPages) {
				showLastPage = true;
			} else {
				showLastPage = false;
			}

		} else {
			hasEndDotDot = false;
			showFirstPage = false;
			showLastPage = false;
		}

	}
    
	/**
	 * 页码滑动窗口，并将当前页尽可能地放在滑动窗口的中间部位。
	 * @param currentPageNumber
	 * @param lastPageNumber
	 * @param count
	 * @return
	 */
	private static Integer[] generateLinkPageNumbers(int currentPageNumber, int lastPageNumber, int count) {
		int avg = count / 2;

		int startPageNumber = currentPageNumber - avg;
		if (startPageNumber <= 0) {
			startPageNumber = 1;
		}

		int endPageNumber = currentPageNumber + avg;
		if (endPageNumber > lastPageNumber) {
			endPageNumber = lastPageNumber;
		}

		List<Integer> result = new ArrayList<Integer>();
		for (int i = startPageNumber; i <= endPageNumber; i++) {
			result.add(new Integer(i));
		}
		return result.toArray(new Integer[result.size()]);
	}

	/**
	 * 计算分页的页码
	 * @param pageNum
	 * @return
	 */
	protected int computePageNo(int pageNum) {
		return computePageNumber(pageNum, Long.valueOf(size).intValue(), Long.valueOf(total).intValue());
	}
	private static int computePageNumber(int pageNum, int pageSize,int totalItems) {
		if(pageNum <= 1) {
			return 1;
		}
		if (Integer.MAX_VALUE == pageNum || pageNum > computeLastPageNumber(totalItems,pageSize)) { //last page
			return computeLastPageNumber(totalItems,pageSize);
		}
		return pageNum;
	}
	private static int computeLastPageNumber(int totalItems,int pageSize) {
		if(pageSize <= 0) return 1;
		int result = (int)(totalItems % pageSize == 0 ? 
				totalItems / pageSize 
				: totalItems / pageSize + 1);
		if(result <= 1)
			result = 1;
		return result;
	}
    
    /**
     * 是否存在上一页
     *
     * @return true / false
     */
    public boolean hasPrevious() {
        return this.current > 1;
    }

    /**
     * 是否存在下一页
     *
     * @return true / false
     */
    public boolean hasNext() {
        return this.current < this.getPages();
    }

    @Override
    public List<T> getRecords() {
        return this.records;
    }

    @Override
    public CrhPageResult<T> setRecords(List<T> records) {
        this.records = records;
        return this;
    }

    @Override
    public long getTotal() {
        return this.total;
    }

    @Override
    public CrhPageResult<T> setTotal(long total) {
        this.total = total;
        this.total_number = total;
        calc();
        return this;
    }

    @Override
    public long getSize() {
        return this.size;
    }

    @Override
    public CrhPageResult<T> setSize(long size) {
        this.size = size;
        return this;
    }

    @Override
    public long getCurrent() {
        return this.current;
    }

    @Override
    public CrhPageResult<T> setCurrent(long current) {
        this.current = current;
        return this;
    }

    /**
     * 获取当前正序排列的字段集合
     * <p>
     * 为了兼容，将在不久后废弃
     *
     * @return 正序排列的字段集合
     * @see #getOrders()
     * @deprecated 3.2.0
     */
    @Override
    @Deprecated
    public String[] ascs() {
        return CollectionUtils.isNotEmpty(orders) ? mapOrderToArray(OrderItem::isAsc) : null;
    }

    /**
     * 查找 order 中正序排序的字段数组
     *
     * @param filter 过滤器
     * @return 返回正序排列的字段数组
     */
    private String[] mapOrderToArray(Predicate<OrderItem> filter) {
        List<String> columns = new ArrayList<>(orders.size());
        orders.forEach(i -> {
            if (filter.test(i)) {
                columns.add(i.getColumn());
            }
        });
        return columns.toArray(new String[0]);
    }

    /**
     * 添加新的排序条件，构造条件可以使用工厂：{@link OrderItem#build(String, boolean)}
     *
     * @param items 条件
     * @return 返回分页参数本身
     */
    public CrhPageResult<T> addOrder(OrderItem... items) {
        orders.addAll(Arrays.asList(items));
        return this;
    }

    /**
     * 添加新的排序条件，构造条件可以使用工厂：{@link OrderItem#build(String, boolean)}
     *
     * @param items 条件
     * @return 返回分页参数本身
     */
    public CrhPageResult<T> addOrder(List<OrderItem> items) {
        orders.addAll(items);
        return this;
    }



    @Override
    public List<OrderItem> orders() {
        return getOrders();
    }

    public List<OrderItem> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderItem> orders) {
        this.orders = orders;
    }

    @Override
    public boolean optimizeCountSql() {
        return optimizeCountSql;
    }

    @Override
    public boolean isSearchCount() {
        if (total < 0) {
            return false;
        }
        return isSearchCount;
    }

    public CrhPageResult<T> setSearchCount(boolean isSearchCount) {
        this.isSearchCount = isSearchCount;
        return this;
    }

    public CrhPageResult<T> setOptimizeCountSql(boolean optimizeCountSql) {
        this.optimizeCountSql = optimizeCountSql;
        return this;
    }

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public boolean isFirstPage() {
		return isFirstPage;
	}

	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}

	public boolean isLastPage() {
		return isLastPage;
	}

	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}

	public boolean isHasPrePage() {
		return hasPrePage;
	}

	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public int getPrePageNum() {
		return prePageNum;
	}

	public void setPrePageNum(int prePageNum) {
		this.prePageNum = prePageNum;
	}

	public int getNextPageNum() {
		return nextPageNum;
	}

	public void setNextPageNum(int nextPageNum) {
		this.nextPageNum = nextPageNum;
	}

	public Boolean getHasBegDotDot() {
		return hasBegDotDot;
	}

	public void setHasBegDotDot(Boolean hasBegDotDot) {
		this.hasBegDotDot = hasBegDotDot;
	}

	public Boolean getHasEndDotDot() {
		return hasEndDotDot;
	}

	public void setHasEndDotDot(Boolean hasEndDotDot) {
		this.hasEndDotDot = hasEndDotDot;
	}

	public Boolean getShowFirstPage() {
		return showFirstPage;
	}

	public void setShowFirstPage(Boolean showFirstPage) {
		this.showFirstPage = showFirstPage;
	}

	public Boolean getShowLastPage() {
		return showLastPage;
	}

	public void setShowLastPage(Boolean showLastPage) {
		this.showLastPage = showLastPage;
	}

	public Integer[] getNumList() {
		return numList;
	}

	public void setNumList(Integer[] numList) {
		this.numList = numList;
	}

	public boolean isOptimizeCountSql() {
		return optimizeCountSql;
	}

	public long getPage_size() {
		return page_size;
	}

	public void setPage_size(long page_size) {
		this.page_size = page_size;
	}

	public long getPage_num() {
		return page_num;
	}

	public void setPage_num(long page_num) {
		this.page_num = page_num;
	}

	public long getTotal_number() {
		return total_number;
	}

	public void setTotal_number(long total_number) {
		this.total_number = total_number;
	}

	public long getTotal_page() {
		return total_page;
	}

	public void setTotal_page(long total_page) {
		this.total_page = total_page;
	}

	public boolean isHas_next() {
		return has_next;
	}

	public void setHas_next(boolean has_next) {
		this.has_next = has_next;
	}
	
	public boolean getHas_next() {
		return has_next;
	}
}
