#/bin/sh

mkdir logs

export LOGNAME=Changelog.`date -u "+%Y%m%d"`
export REV_NOW=`mtn automate heads |head -n1`

if test -e oldrev ; then
    export OLD_REV=`cat oldrev`
else
    export OLD_REV="l:\"1 week ago\""
fi

for i in `mtn log --brief --no-graph --no-merges --to "${OLD_REV}" --from "${REV_NOW}"| awk '{print $2 ":" $1}'` ; do \
        export REV=`echo $i | awk -F: '{print $2}'`
        export AUTHOR=`echo $i | awk -F: '{print $1}'`
        export CL=`mtn ls certs ${REV} | grep -A 1 changelog | grep -v changelog | gawk -F'Value : '  '{ print $2 }'`
        if test -n "${CL}"  ; then
                echo "    ${CL}" >> logs/${AUTHOR}
        fi
done

cd logs
for i in * ; do \
        echo $i: >> ../${LOGNAME}
        cat $i >> ../${LOGNAME}
        echo >> ../${LOGNAME}
done
cd ..

wget 'http://bugs.openembedded.org/buglist.cgi?bug_file_loc=&bug_file_loc_type=allwordssubstr&bug_id=&bug_status=RESOLVED&bug_status=VERIFIED&bug_status=CLOSED&bugidtype=include&chfieldfrom=7d&chfieldto=Now&chfieldvalue=&email1=&email2=&emailassigned_to1=1&emailassigned_to2=1&emailcc2=1&emailqa_contact2=1&emailreporter2=1&emailtype1=substring&emailtype2=substring&field-1-0-0=bug_status&field0-0-0=noop&known_name=1WFixed&long_desc=&long_desc_type=substring&query_format=advanced&remaction=&short_desc=&short_desc_type=allwordssubstr&type-1-0-0=anyexact&type0-0-0=noop&value-1-0-0=RESOLVED%2CVERIFIED%2CCLOSED&value0-0-0=&ctype=csv' -O logs/resolved-bugs.csv >& /dev/null

wget "http://bugs.openembedded.org/buglist.cgi?bug_file_loc=&bug_file_loc_type=allwordssubstr&bug_id=&bug_status=NEW&bugidtype=include&chfield=%5BBug%20creation%5D&chfieldfrom=7d&chfieldto=Now&chfieldvalue=&email1=&email2=&emailassigned_to1=1&emailassigned_to2=1&emailcc2=1&emailqa_contact2=1&emailreporter2=1&emailtype1=substring&emailtype2=substring&field-1-0-0=bug_status&field0-0-0=noop&long_desc=&long_desc_type=substring&query_format=advanced&remaction=&short_desc=&short_desc_type=allwordssubstr&type-1-0-0=anyexact&type0-0-0=noop&value-1-0-0=NEW&value0-0-0=&ctype=csv" -O logs/new-bugs.csv &>/dev/null

NEW_BUGS="`cat logs/new-bugs.csv | wc -l | tr -d " "`"
RESOLVED_BUGS="`cat logs/resolved-bugs.csv | wc -l | tr -d " "`"

echo -e "\n\nBugs fixed:" >> ${LOGNAME}
cat logs/resolved-bugs.csv | awk -F, '{print $1 " " $7 "\t " $8}' | sed s:\"::g >> ${LOGNAME}

echo -e "\n\nBugs opened:" >> ${LOGNAME}
cat logs/new-bugs.csv | awk -F, '{print $1 " " $7 "\t " $8}' | sed s:\"::g >> ${LOGNAME}

echo -e "\nIn total $NEW_BUGS bugs have been created and $RESOLVED_BUGS bugs were closed." >> ${LOGNAME}

echo ${REV_NOW} > oldrev

rm -Rf logs 

