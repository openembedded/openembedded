require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_core_${APPNAME}.tar.bz2;name=split_core_appname \
	   http://sources.openembedded.org/opie-1.2.4-split_core_apps_calibrate.tar.bz2;name=split_core_apps_calibrate \
	   http://sources.openembedded.org/opie-1.2.4-split_core_launcher.tar.bz2;name=split_core_launcher \
	   file://opie-session \
	   file://post-session \
	   file://pre-session \
	   file://opie-login.conf"
SRC_URI[split_core_appname.md5sum] = "d33537414962d6a6556edba12439a5e9"
SRC_URI[split_core_appname.sha256sum] = "14ea6820ff77cebf86894f8e0dfab3f186969962af784820bde8ef1d228f2272"
SRC_URI[split_core_apps_calibrate.md5sum] = "daf8aaf7ca9ca16834103586373efe86"
SRC_URI[split_core_apps_calibrate.sha256sum] = "061af18519e45b2e7e87e41b09c10d2baea3b94db8cffc96412290615ef3b3bc"
SRC_URI[split_core_launcher.md5sum] = "40b7dbd39f79946e32238eed5708fbc8"
SRC_URI[split_core_launcher.sha256sum] = "1813ac4adf8f56ada5b827d2c7950a76e271680f544edfe1a17c92e7bd0bc632"
