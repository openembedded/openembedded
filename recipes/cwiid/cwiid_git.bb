DESCRIPTION = "wiimote library + tools"
LICENSE = "GPLv2"
HOMEPAGE = "http://abstrakraft.org/cwiid/"

SRCREV = "fadf11e89b579bcc0336a0692ac15c93785f3f82"
PV = "0.6.00+gitr${SRCREV}"

inherit autotools
inherit distutils-base

export BUILD_SYS
export HOST_SYS

PARALLEL_MAKE = ""

SRC_URI = "git://github.com/abstrakraft/cwiid.git;protocol=git"
S = "${WORKDIR}/git"

EXTRA_OECONF = "--disable-ldconfig"

FILES_${PN} += "\
	${sysconfdir}/cwiid/ \
"

FILES_${PN}-dbg += "\
	${libdir}/cwiid/plugins/.debug \
"

do_configure_append() {
	find ${S} -name Makefile | xargs sed -i s:'-I$(includedir)':'-I.':g
 	find ${S} -name Makefile | xargs sed -i s:'-I/usr/include':'-I${STAGING_INCDIR}':g
}


