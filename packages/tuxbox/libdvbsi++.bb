DEPENDS = "dreambox-dvbincludes"
DESCRIPTION = "libdvbsi++ by obi@saftware.de"
MAINTAINER = "Felix Domke <tmbinc@elitdvb.net>"

SRC_URI = "cvs://anoncvs@cvs.tuxbox.org/cvs/tuxbox;module=apps/dvb/libdvbsi++;method=ext"
	   
CVSDATE = "20051129"
PR = "r0"
PV = "0.0+cvs${CVSDATE}"
S = "${WORKDIR}/libdvbsi++"

inherit autotools pkgconfig

bindir = "/usr/bin"
sbindir = "/usr/sbin"

do_stage_append() {
	install -d ${STAGING_INCDIR}/dvbsi++
	install -m 0644 ${S}/include/dvbsi++/*.h ${STAGING_INCDIR}/dvbsi++
	cd ${S}/src
	oe_libinstall -so libdvbsi++ ${STAGING_LIBDIR}
}

EXTRA_OECONF = "--with-target=cdk"
