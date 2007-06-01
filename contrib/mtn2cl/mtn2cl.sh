#/bin/sh

# This script takes the last 1000 revs and writes a ChangeLog

for i in `mtn log --brief --no-graph --no-merges --to 57d2b2fc5c8e07d46b3aff668037c245742efd52 | awk '{print $2 ":" $1}'` ; do \
        export REV=`echo $i | awk -F: '{print $2}'`
        export AUTHOR=`echo $i | awk -F: '{print $1}'`
        export CL=`mtn ls certs ${REV} | grep -A 1 changelog | grep -v changelog | gawk -F'Value : '  '{ print $2 }'`
        if test -n "${CL}"  ; then
                echo "    ${CL}" >> ${AUTHOR}
        fi
done

for i in *@* ; do \
        echo $i: >> ChangeLog
        cat $i >> ChangeLog
        echo >> ChangeLog
done

rm `ls | grep -v ChangeLog | grep -v mtn2cl`

