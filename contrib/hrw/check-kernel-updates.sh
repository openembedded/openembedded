
echo "fetching list of changelogs"
#echo "ls ChangeLog-*" |lftp ftp://www.kernel.org/pub/linux/kernel/v2.6/> changes.txt

for release in `seq 16 32`;
do
    LATEST=`grep ChangeLog-2.6.$release changes.txt | sed -e "s/^.*ChangeLog-2.6.$release.//g"| sort -n -r|head -n1`
    echo "latest patch: 2.6.$release.$LATEST"
done
