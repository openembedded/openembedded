#!/bin/sh
#Path to your Roms if you want to disable the menu
#LOCATION=/mnt/card/games/snes

# Give a default
if test -e /root/Settings/opie-sh-snes.conf
then
	LOCATION="`cat /root/Settings/opie-sh-snes.conf`"
else
	echo "/mnt/card/games/snes" > /root/Settings/opie-sh-snes.conf
	#Enable Menu Rom Finder
	LOCATION="` opie-sh -i -t "Path to Roms" -g -E -l -F /root/Settings/opie-sh-snes.conf `"
	! test -z "$LOCATION" && echo $LOCATION > /root/Settings/opie-sh-snes.conf
fi	

echo "LOCATION = [$LOCATION]"
if [ "$LOCATION" = "" ]; then exit; fi


#Load a game from your list
ROM=`	cd "$LOCATION" ; ls -1 *.zip \
	| opie-sh -i -l -t "Snes9x" -F  -g `
if [ "$ROM" = "" ]; then exit; fi

echo "ROM = [$ROM]"

#Enable Sound Button
setsound () {
	opie-sh -m -t "Sound"	\
	-M "Do you want sound?"	\
	-g -0 Yes -1 No
RETURNCODE=$?

case $RETURNCODE in
        0)  SOUND="-sound" ;;
        1)  SOUND="-nosound" ;;
esac

echo "SOUND = [$SOUND] / RC = [$?]"
}


setsound



if [ "$SOUND" = "" ]; then exit; fi


snes9x $SOUND "$LOCATION/$ROM"
