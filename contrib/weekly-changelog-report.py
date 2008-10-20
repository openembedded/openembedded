#!/usr/bin/python


# generates an OE changelog for last weeks activity (Mon-Sun) assuming it is run on
# any day of the following week

import datetime
import os

today = datetime.date.today()

# 0 = Mon, 6 = Sun
today_weekday = today.weekday()

# find Mon of this week
end_day = today - datetime.timedelta(today_weekday)

start_day = end_day - datetime.timedelta(7)

print "OE weekly changelog %s to %s\n" % (start_day.isoformat(), end_day.isoformat())

os.system("git-shortlog --since=%s --until=%s" % (start_day.isoformat(), end_day.isoformat()))


