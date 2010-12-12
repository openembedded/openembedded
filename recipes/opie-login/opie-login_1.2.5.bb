require ${PN}.inc

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_core_${APPNAME}.tar.bz2 \
	   http://sources.openembedded.org/opie-1.2.5-split_core_apps_calibrate.tar.bz2 \
	   http://sources.openembedded.org/opie-1.2.5-split_core_launcher.tar.bz2 \
	   file://opie-session \
	   file://post-session \
	   file://pre-session \
	   file://opie-login.conf"
