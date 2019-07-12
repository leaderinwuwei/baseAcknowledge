package cn.spring.study.testmodel;

import java.io.Serializable;

/**
 * 2 * @Author: WF
 * 3 * @Date: 2019/7/12/012 10:32
 * 4
 */
public class LongBean implements Serializable {
    private Long aLong;
    private static final long serialVersionUID = 1L;
    public Long getaLong() {
        return aLong;
    }

    public void setaLong(Long aLong) {
        this.aLong = aLong;
    }
}
