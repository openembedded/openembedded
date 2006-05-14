DESCRIPTION = "Daemon to handle device specifc features."
SECTION = "base"
MAINTAINER = "Richard Purdie <rpurdie@openedhand.com>"
LICENSE = "GPL"
DEPENDS = "tslib"
PV = "0.0+svn${SRCDATE}"
PR = "r5"

SRC_URI = "svn://svn.o-hand.com/repos/misc/trunk;module=zaurusd;proto=http \
           file://zaurus-hinge.in \
	   file://add-poodle.patch;patch=1"

S = "${WORKDIR}/${PN}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_configure_prepend () {
	cp ${WORKDIR}/zaurus-hinge.in ${S}/scripts
}

inherit autotools pkgconfig update-rc.d

INITSCRIPT_NAME = "zaurusd"
INITSCRIPT_PARAMS = "start 99 5 2 . stop 20 0 1 6 ."
