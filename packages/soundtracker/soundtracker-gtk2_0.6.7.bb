DESCRIPTION = "Music composition program in the style of AMIGA Impulse Tracker"
DEPENDS = "gtk+ libgnomeui audiofile esound-gpe alsa-lib"
LICENSE = "GPL"
SECTION = "x11/multimedia"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
PR = "r0"

SRC_URI = "http://metamorph0sis.nm.ru/soundtracker-${PV}-2.gtk2.tar.bz2"
S = "${WORKDIR}/soundtracker-${PV}.gtk2"

inherit autotools

EXTRA_OECONF = "--disable-asm"

do_configure() {
	oe_runconf
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 app/soundtracker ${D}${bindir}
}

