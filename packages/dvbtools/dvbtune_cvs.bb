PV = "0.0+cvs${SRCDATE}"
SECTION = "console/multimedia"
PRIORITY = "optional"
LICENSE = "GPLv2"
MAINTAINER = "Phil Blundell <pb@debian.org>"
DEPENDS = "libxml2"
SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/dvbtools;module=dvbtune"
S = "${WORKDIR}/dvbtune"

CFLAGS += "\$(shell xml2-config --cflags)"
LDFLAGS += "\$(shell xml2-config --libs)"

do_compile() {
	oe_runmake dvbtune xml2vdr
}

do_install() {
	mkdir -p ${D}${bindir}
	install -m 0755 dvbtune ${D}${bindir}/
	install -m 0755 xml2vdr ${D}${bindir}/
}
