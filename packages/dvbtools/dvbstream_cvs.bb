PV = "0.0cvs${CVSDATE}"
SECTION = "console/multimedia"
PRIORITY = "optional"
LICENSE = "GPLV2"
MAINTAINER = "Phil Blundell <pb@debian.org>"
DEPENDS = "libxml2"
SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/dvbtools;module=dvbstream"
S = "${WORKDIR}/dvbstream"

CFLAGS_append = " -D_GNU_SOURCE"

do_install() {
	mkdir -p ${D}${bindir}
	for i in dvbstream dumprtp ts_filter rtpfeed; do install -m 0755 $i ${D}${bindir}/; done
}
