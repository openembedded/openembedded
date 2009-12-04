DESCRIPTION = "wiimote library + tools"
LICENSE = "GPLv2"
HOMEPAGE = "http://abstrakraft.org/cwiid/"

SRCREV = "192"
PV = "0.6.00+svnr${SRCPV}"

inherit autotools
inherit distutils-base

export BUILD_SYS
export HOST_SYS

PARALLEL_MAKE = ""

SRC_URI = "svn://abstrakraft.org/cwiid/svn/;module=trunk;proto=http"
S = "${WORKDIR}/trunk"

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


