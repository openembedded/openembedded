DEPENDS = "enigma"
DESCRIPTION = "Genuine Dreambox"
MAINTAINER = "Mechatron <mechatron@gmx.net>"
LICENSE = "GPL"

RDEPENDS = "dreambox-tpmd"

SRCDATE = "20090812"
PV = "cvs${SRCDATE}"
PN = "enigma-genuine-dreambox"
PACKAGES = "enigma-genuine-dreambox"
SRC_URI = "cvs://anonymous@cvs.schwerkraft.elitedvb.net/cvsroot/genuinedreambox;module=genuine_dreambox_e1;method=pserver;date=${SRCDATE}"
S = "${WORKDIR}/genuine_dreambox_e1"

inherit autotools pkgconfig

bindir = "/usr/bin"
sbindir = "/usr/sbin"

EXTRA_OECONF = "--with-target=native "

do_install() {
	install -d ${D}/usr/lib/tuxbox/plugins
	install ${S}/.libs/enigma_genuine_dreambox.so ${D}/usr/lib/tuxbox/plugins
	install -m 0644 ${S}/enigma_genuine_dreambox.cfg ${D}/usr/lib/tuxbox/plugins
}

FILES_${PN} = "/"
