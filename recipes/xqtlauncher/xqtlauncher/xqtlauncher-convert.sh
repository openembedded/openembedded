#!/bin/ash
#This program converts /usr/share/applications/*.desktop in /usr/lib/opie/apps/XQt2/*.desktop files. 
for i in `find /usr/share/applications -name *.desktop`; do
	export name=$(echo $i | awk 'BEGIN {FS="."} {gsub("/",".")} {print $(NF-1)}')
	newfile=/usr/lib/opie/apps/XQt2/$name.desktop
	if [ ! -f $newfile ] ; then
		#cat $i | awk 'BEGIN {FS="="} {if ($1 == "Exec") {print "Exec=run"ENVIRON["name"]" " $2} else if ($1 == "Icon") {print "Icon=/usr/share/pixmaps/"$2} else  {print $0} }' > $newfile
		cat $i | awk 'BEGIN {FS="="} {if ($1 == "Exec") {print "Exec=/usr/lib/opie/bin/run"ENVIRON["name"]" " $2} else  {print $0} }' > $newfile
		icon=$(cat $i | awk 'BEGIN {FS="="} {if ($1 == "Icon") {print $2} }')
		ln -sf /usr/bin/xqtlauncher /usr/lib/opie/bin/run$name
		#We need to make symlinks for the pics because opie can not handle pics with paths :(		
		#Check if it has a leading /!
		if expr $icon : />/dev/null ; then
			echo $icon
			ln -sf $icon /usr/lib/opie/pics/$(echo $icon | awk 'BEGIN {FS="/"} {print $NF}')
		else
			echo $icon
			ln -sf $(find /usr/share/pixmaps -name $icon) /usr/lib/opie/pics/$(echo $icon | awk 'BEGIN {FS="/"} {print $NF}')
		fi
	fi
done
#update the icons
/usr/bin/icon-reload.sh
