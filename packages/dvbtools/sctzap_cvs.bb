PV = "0.0cvs${SRCDATE}"
SECTION = "console/multimedia"
PRIORITY = "optional"
LICENSE = "GPLv2"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
SRC_URI = "cvs://anonymous@cvs.linuxtv.org/cvs/linuxtv;module=dvb-apps/util/szap \
           cvs://anonymous@cvs.linuxtv.org/cvs/linuxtv;module=dvb-apps/util/lib"
S = "${WORKDIR}/szap"

CFLAGS_append = " -I../lib "

do_compile() {
	oe_runmake szap czap tzap femon
}

do_install() {
	mkdir -p ${D}${bindir}
	install -m 0755 szap ${D}${bindir}/
	install -m 0755 czap ${D}${bindir}/
	install -m 0755 tzap ${D}${bindir}/
	install -m 0755 femon ${D}${bindir}/
}
