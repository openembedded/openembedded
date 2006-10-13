DESCRIPTION = "Reads YAMON environment-variables"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"
SRCDATE = "20050909"
PV = "1.0.0+cvs${SRCDATE}"

SRC_URI = "http://meshcube.org/download/${PN}_${SRCDATE}.tgz"
S = "${WORKDIR}/${PN}"

do_install() {
	install -d ${D}${sbindir}
	install -m 755 ${S}/src/yamonenv ${D}${sbindir}
}
