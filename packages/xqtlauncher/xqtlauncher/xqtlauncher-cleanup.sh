#!/bin/ash
#This program cleans up the mess which convert.sh leaves if you remove a package 
for i in `find /usr/lib/opie/apps/XQt2 -name *.desktop`; do
	export name=$(echo $i | awk 'BEGIN {FS="."} {gsub("/",".")} {print $(NF-1)}')
	#don't delete convert and cleanup icons
    if [ $i != "/usr/lib/opie/apps/XQt2/convert.desktop" ] && [ $i != "/usr/lib/opie/apps/XQt2/cleanup.desktop" ] ; then 
        newfile=$(find /usr/share/applications/ -name $name.desktop)
    else
        newfile="donotdelete"
    fi
	if [ -z $newfile ] ; then
		echo $name
		echo $i
		icon=$(cat $i | awk 'BEGIN {FS="="} {if ($1 == "Icon") {print $2} }')
		rm -f /usr/lib/opie/bin/run$name
		find /usr/lib/opie/pics/ -name $icon.* -exec rm -f {} \;
		rm -f $i
	fi
done
#update the icons
/usr/bin/icon-reload.sh
