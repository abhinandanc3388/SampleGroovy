import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters

def call(names) {
    echo "Hey ${names} , How are you ?"

    def flag = false

    def currDate = LocalDate.now()
    def thirdDay = currDate.with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.SUNDAY));

    if (currDate.equals(thirdDay)) {
        flag = true
    }

    echo "${flag}"


    Jenkins.instance.getAllItems(AbstractItem.class).each {
        println it.fullName + " - " + it.class
    };
}





