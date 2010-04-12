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

SRC_URI[md5sum] = "a3e4f24155aa3ba5aa502bc63fdaa6ad"
SRC_URI[sha256sum] = "466eca9cdad2c15e957fb9ce7d0b6927ecd17d85c4cc2dff37e97a3e6b209c67"
