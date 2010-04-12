DESCRIPTION = "Reads YAMON environment-variables"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"
SRCDATE = "20051022"
PV = "1.0.0+cvs${SRCDATE}"

SRC_URI = "http://download.berlin.freifunk.net/meshcube.org/nylon/stable/sources/${PN}_gruen.4g__${SRCDATE}.tar.gz"
S = "${WORKDIR}/${PN}"

do_install() {
	install -d ${D}${sbindir}
	install -m 755 ${S}/src/yamonenv ${D}${sbindir}
}
