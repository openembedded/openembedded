DESCRIPTION = "Userland utilities for the FBUI in kernel GUI"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
SECTION = "base"

SRC_URI = "http://home.comcast.net/~plinius/fbui-${PV}.tar.bz2"
S = "${WORKDIR}/libfbui"

do_compile() {
	./cleanall.sh

	FILES="libfbui.a libfbui.o Calc/fbcalc Launcher/fblauncher \
		Clock/fbclock Term/fbterm LoadMonitor/fbload Viewer/fbview \
		MailCheck/fbcheck Test/fbtest WindowManager/fbwm PanelManager/fbpm \
		ToDo/fbtodo MPEG/mpeg2decode"

	DIRS=". Calc Launcher MPEG Test Clock ToDo Term LoadMonitor Viewer \
		MailCheck Dump WindowManager PanelManager"

	for FILE in $FILES
	do
		rm -f $FILE
	done

	for DIR in $DIRS
	do
		cd $DIR
		oe_runmake
		if [ "$DIR" != "." ]
		then cd ..
		fi
	done
}
