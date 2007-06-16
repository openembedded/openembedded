#/bin/sh

# This script takes the last 1000 revs and writes a ChangeLog

mkdir logs

export REV_NOW=`mtn automate heads |head -n1`

for i in `mtn log --brief --no-graph --no-merges --from l:"1 week ago" --to ${REV_NOW}| awk '{print $2 ":" $1}'` ; do \
        export REV=`echo $i | awk -F: '{print $2}'`
        export AUTHOR=`echo $i | awk -F: '{print $1}'`
        export CL=`mtn ls certs ${REV} | grep -A 1 changelog | grep -v changelog | gawk -F'Value : '  '{ print $2 }'`
        if test -n "${CL}"  ; then
                echo "    ${CL}" >> logs/${AUTHOR}
        fi
done

cd logs
for i in * ; do \
        echo $i: >> ../ChangeLog
        cat $i >> ../ChangeLog
        echo >> ../ChangeLog
done
cd ..

echo "Bug fixed:" >> ChangeLog

wget 'http://bugs.openembedded.org/buglist.cgi?bug_file_loc=&bug_file_loc_type=allwordssubstr&bug_id=&bug_status=RESOLVED&bug_status=VERIFIED&bug_status=CLOSED&bugidtype=include&chfieldfrom=7d&chfieldto=Now&chfieldvalue=&email1=&email2=&emailassigned_to1=1&emailassigned_to2=1&emailcc2=1&emailqa_contact2=1&emailreporter2=1&emailtype1=substring&emailtype2=substring&field-1-0-0=bug_status&field0-0-0=noop&known_name=1WFixed&long_desc=&long_desc_type=substring&query_format=advanced&remaction=&short_desc=&short_desc_type=allwordssubstr&type-1-0-0=anyexact&type0-0-0=noop&value-1-0-0=RESOLVED%2CVERIFIED%2CCLOSED&value0-0-0=&ctype=csv' -O logs/bugs.csv >& /dev/null

cat logs/bugs.csv | awk -F, '{print $1 " " $7 "\t " $8}' | sed s:\"::g >> ChangeLog

rm -Rf logs 

