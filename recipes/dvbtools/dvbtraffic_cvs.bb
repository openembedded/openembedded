DESCRIPTION = "dvbtraffic is a tool to display all pids on a transport stream"
SECTION = "console/multimedia"
PRIORITY = "optional"
LICENSE = "GPLv2"
SRCDATE = "20090621"
PV = "0.0cvs${SRCDATE}"

SRC_URI = "cvs://anonymous@cvs.linuxtv.org/cvs/linuxtv;module=dvb-apps/util/dvbtraffic"

S = "${WORKDIR}/dvbtraffic"
CFLAGS_append = " ${LDFLAGS} -D PATH_MAX=128"

do_compile() {
	oe_runmake dvbtraffic
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 dvbtraffic ${D}${bindir}/
}
