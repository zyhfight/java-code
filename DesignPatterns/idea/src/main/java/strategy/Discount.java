package strategy;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 抽象策略类
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-7-23
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-23     zyh           v1.0.0               修改原因
 */
public interface Discount {
    double calculate(double price);
}
