package com.bywin.base.test;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * created by yeric on 2019/10/24
 */
public class DateTest {
    /**
     * 当月第几天
     */
    private final int i = LocalDate.now().getDayOfMonth();
    /**
     * 上一个月的今天（如果上个月没有31号，会自动取上个月的最后一天）
     */
    private final LocalDate preLocalDate = LocalDate.now().minusMonths(1);
    private final LocalDate preFirstDay = LocalDate.of(preLocalDate.getYear(), preLocalDate.getMonth(), 1);

    private final LocalDate preLastDayLocalDate = preLocalDate.with(TemporalAdjusters.lastDayOfMonth());
    /**
     * 上一个月的最后一天
     */
    private final Date preLastDay = Date.from(preLastDayLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

    /**
     * 上一个月的第一天 （Date类型）
     */
    private final Date lFirstDate = Date.from(preFirstDay.atStartOfDay(ZoneId.systemDefault()).toInstant());
    /**
     * LocalDate转换成Date类型(上一个月的今天)，跟new Date()对应
     */
    private final Date preDate = Date.from(preLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    private final LocalDate firstDay = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1);
    /**
     * 本月第一天（Date类型）
     */
    private final Date nFirstDate = Date.from(firstDay.atStartOfDay(ZoneId.systemDefault()).toInstant());
    private final LocalDate sevenAgoLocalDate = LocalDate.now().minusWeeks(1);

    /**
     * 上线日期
     */
    private final LocalDate onLineDate = LocalDate.of(2019, 10, 1);

    public final static LocalDate yesterday = LocalDate.now().minusDays(1);
    /**
     * 昨天的日期
     */
    public final static Date oneAgoDate = Date.from(yesterday.atStartOfDay(ZoneId.systemDefault()).toInstant());
    /**
     * 上线日期到今日的天数差
     */
    private final long dayDiff = yesterday.toEpochDay() - onLineDate.toEpochDay();
    /**
     * 一周前（从昨天开始算）
     */
    private final Date sevenAgoDate = Date.from(yesterday.atStartOfDay(ZoneId.systemDefault()).toInstant());
    private final DateFormat sdf1 = new SimpleDateFormat("yyyy-MM");
    /**
     * 上月月份与上线月份之间差的月数
     */
    private final long monthDiff = ChronoUnit.MONTHS.between(onLineDate, LocalDate.now());
    public static void main(String[] args) throws Exception {

        LocalDate preLocalDate = LocalDate.now().minusMonths(1);
        LocalDate preLastDayLocalDate = preLocalDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(preLastDayLocalDate);
        LocalDate now = LocalDate.now();
        LocalDate endDate = LocalDate.of(2019, 5, 1);
        LocalDate lastDay = endDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDay);
        System.out.println(endDate.getDayOfMonth());
        long month = ChronoUnit.MONTHS.between(endDate, now);
        System.out.println(month);
        String s = listToString(Arrays.asList("a,b,c".split(",")), '|');
        System.out.println(s);
    }

    public static String listToString(List list, char separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(separator);
        }
        return sb.toString().substring(0, sb.toString().length() - 1);
    }

    /**
     * 获取上个月最后一天的日期
     *
     * @return
     */
    public static Date getLastDay4LastMonth() {
     /*   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse("2019-03-31");
            Calendar c = Calendar.getInstance();
            //设置为指定日期
            c.setTime(date);
            //指定日期月份减去一
            c.add(Calendar.MONTH, -1);
            //指定日期月份减去一后的 最大天数
            c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
            //获取最终的时间
            Date lastDateOfPrevMonth = c.getTime();
            System.out.println("上月最后一天：" + sdf.format(lastDateOfPrevMonth));
        } catch (Exception e) {
        }*/
        return null;
    }

    public static String getStartDate(String date) throws Exception {
        String resultString;
        try {
            if (StringUtils.isEmpty(date)) {
                return getEndDate();
            }
            Calendar cal = Calendar.getInstance();
            java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
            cal.add(Calendar.MONTH, -1);
            int day = Integer.parseInt(StringUtils.substring(date, StringUtils.lastIndexOf(date, "-") + 1, date.length()));
            cal.set(Calendar.DATE, day);
            String lastMonthStart = format.format(cal.getTime());//上月开始
            cal.clear();
            resultString = lastMonthStart;
        } catch (Exception e) {
            return getEndDate();
        }
        return resultString;

    }

    private static String getEndDate() throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        return df.format(df.parse("2019-10-31"));// new Date()为获取当前系统时间
    }
}
