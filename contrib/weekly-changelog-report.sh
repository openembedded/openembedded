#!/bin/sh

echo "====================================================="
./contrib/weekly-changelog-report.py
echo
echo "====================================================="
./contrib/weekly-changelog-report.py origin/holger/staging-branch
echo

wget 'http://bugs.openembedded.net/buglist.cgi?bug_file_loc=&bug_file_loc_type=allwordssubstr&bug_id=&bug_status=RESOLVED&bug_status=VERIFIED&bug_status=CLOSED&bugidtype=include&chfieldfrom=7d&chfieldto=Now&chfieldvalue=&email1=&email2=&emailassigned_to1=1&emailassigned_to2=1&emailcc2=1&emailqa_contact2=1&emailreporter2=1&emailtype1=substring&emailtype2=substring&field-1-0-0=bug_status&field0-0-0=noop&known_name=1WFixed&long_desc=&long_desc_type=substring&query_format=advanced&remaction=&short_desc=&short_desc_type=allwordssubstr&type-1-0-0=anyexact&type0-0-0=noop&value-1-0-0=RESOLVED%2CVERIFIED%2CCLOSED&value0-0-0=&ctype=csv' -O resolved-bugs.csv >& /dev/null

wget 'http://bugs.openembedded.net/buglist.cgi?bug_file_loc=&bug_file_loc_type=allwordssubstr&bug_id=&bug_status=NEW&bugidtype=include&chfield=%5BBug%20creation%5D&chfieldfrom=7d&chfieldto=Now&chfieldvalue=&email1=&email2=&emailassigned_to1=1&emailassigned_to2=1&emailcc2=1&emailqa_contact2=1&emailreporter2=1&emailtype1=substring&emailtype2=substring&field-1-0-0=bug_status&field0-0-0=noop&long_desc=&long_desc_type=substring&query_format=advanced&remaction=&short_desc=&short_desc_type=allwordssubstr&type-1-0-0=anyexact&type0-0-0=noop&value-1-0-0=NEW&value0-0-0=&ctype=csv' -O new-bugs.csv &> /dev/null

echo "====================================================="
echo "Bugs fixed:"
cat resolved-bugs.csv | awk -F, '{print $1 " " $7 "\t " $8}' | sed s:\\\"::g

echo
echo "Bugs opened:"
cat new-bugs.csv | awk -F, '{print $1 " " $7 "\t " $8}' | sed s:\\\"::g

