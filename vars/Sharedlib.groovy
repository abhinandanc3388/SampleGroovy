def call(names) {
    echo "Hey ${names} , How are you ?"

    def flag = false

    //  def currDate = LocalDate.now()
    //  def thirdDay = currDate.with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.SUNDAY));
    def l_date = nthWeekdayOfMonth(6, 2, 2022, TimeZone.getTimeZone("Europe/London"))
    if (currDate.equals(thirdDay)) {
        flag = true
    }

    echo "${flag}"

    echo "${l_date}"


    Jenkins.instance.getAllItems(AbstractItem.class).each {
        println it.fullName + " - " + it.class
    };
}

def nthWeekdayOfMonth(int dayOfWeek, int month, int year, int week, TimeZone timeZone) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeZone(timeZone);
    calendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);
    calendar.set(Calendar.WEEK_OF_MONTH, week);
    calendar.set(Calendar.MONTH, month);
    calendar.set(Calendar.YEAR, year);
    return calendar.getTime();
}



