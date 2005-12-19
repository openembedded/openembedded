DEPENDS = "enigma mrouted"
RDEPENDS = "enigma mrouted"
DESCRIPTION = "Enigma Plugin dreamdata"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
LICENSE = "GPL"
PV = "0.0.9"
PR = "r1"
PN = "dreamdata"
PACKAGES = "dreamdata"
SRC_URI =  "http://sources.dreamboxupdate.com/download/opendreambox/enigma/dreamdata-${PV}-r1.tar.bz2"

S = "${WORKDIR}/dreamdata"

inherit autotools pkgconfig

EXTRA_OECONF = "--with-target=native "

do_install() {
	install -d ${D}/usr/lib/tuxbox/plugins
	install -d ${D}/etc
	install ${S}/.libs/dreamdata.so ${D}/usr/lib/tuxbox/plugins
	install -m 0644 ${S}/dreamdata.cfg ${D}/usr/lib/tuxbox/plugins
	install -m 0644 ${S}/dreamdata.xml ${D}/etc
}

FILES_${PN} = "/"
