DESCRIPTION = "Daemon to handle device specifc features."
SECTION = "base"
MAINTAINER = "Richard Purdie <rpurdie@openedhand.com>"
LICENSE = "GPL"
DEPENDS = "tslib"
PV = "0.0+svn${CVSDATE}"
PR = "r3"

SRC_URI = "svn://svn.o-hand.com/repos/misc/trunk;module=zaurusd;proto=http \
           file://fix-c7x0-sound.patch;patch=1 \
           file://no-suspend-on-hinge.patch;patch=1 \
	   file://mbinputmgr-honor-user-prefs.patch;patch=1"

S = "${WORKDIR}/${PN}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools pkgconfig update-rc.d

INITSCRIPT_NAME = "zaurusd"
INITSCRIPT_PARAMS = "start 99 5 2 . stop 20 0 1 6 ."
