#!/usr/bin/python


# generates an OE changelog for last weeks activity (Mon-Sun) assuming it is run on
# any day of the following week

# TODO
# - remove patch count as it does not match after we remove "Merge branch" statements
# - add bugzilla info

import datetime
import os
import sys
import string

today = datetime.date.today()

# 0 = Mon, 6 = Sun
today_weekday = today.weekday()

# find Mon of this week
end_day = today - datetime.timedelta(today_weekday)

start_day = end_day - datetime.timedelta(7)

if (len(sys.argv) <= 1):
    branch = "origin/org.openembedded.dev"
else:
    branch = sys.argv[1]

branch_pretty = string.replace(branch, "origin/", "")

print "OE weekly changelog for %s, %s to %s\n" % (branch_pretty, start_day.isoformat(), end_day.isoformat())
os.system("git shortlog --since=%s --until=%s %s | grep -v 'Merge branch' | grep -v 'Merge commit'|sed -e 's/^    //g'|cut -b -78 " % (start_day.isoformat(), end_day.isoformat(), branch))

sys.exit(0)

os.system("wget 'http://bugs.openembedded.net/buglist.cgi?bug_file_loc=&bug_file_loc_type=allwordssubstr&bug_id=&bug_status=RESOLVED&bug_status=VERIFIED&bug_status=CLOSED&bugidtype=include&chfieldfrom=7d&chfieldto=Now&chfieldvalue=&email1=&email2=&emailassigned_to1=1&emailassigned_to2=1&emailcc2=1&emailqa_contact2=1&emailreporter2=1&emailtype1=substring&emailtype2=substring&field-1-0-0=bug_status&field0-0-0=noop&known_name=1WFixed&long_desc=&long_desc_type=substring&query_format=advanced&remaction=&short_desc=&short_desc_type=allwordssubstr&type-1-0-0=anyexact&type0-0-0=noop&value-1-0-0=RESOLVED%2CVERIFIED%2CCLOSED&value0-0-0=&ctype=csv' -O resolved-bugs.csv >& /dev/null")
os.system("wget 'http://bugs.openembedded.net/buglist.cgi?bug_file_loc=&bug_file_loc_type=allwordssubstr&bug_id=&bug_status=NEW&bugidtype=include&chfield=%5BBug%20creation%5D&chfieldfrom=7d&chfieldto=Now&chfieldvalue=&email1=&email2=&emailassigned_to1=1&emailassigned_to2=1&emailcc2=1&emailqa_contact2=1&emailreporter2=1&emailtype1=substring&emailtype2=substring&field-1-0-0=bug_status&field0-0-0=noop&long_desc=&long_desc_type=substring&query_format=advanced&remaction=&short_desc=&short_desc_type=allwordssubstr&type-1-0-0=anyexact&type0-0-0=noop&value-1-0-0=NEW&value0-0-0=&ctype=csv' -O new-bugs.csv &> /dev/null")


print "====================================================="
print "Bugs fixed:\n"

os.system("cat resolved-bugs.csv | awk -F, '{print $1 \" \" $7 \"\t \" $8}' | sed s:\\\"::g")

print "\nBugs opened:\n"

os.system("cat new-bugs.csv | awk -F, '{print $1 \" \" $7 \"\t \" $8}' | sed s:\\\"::g")


