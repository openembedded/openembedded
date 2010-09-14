DESCRIPTION = "Music composition program in the style of AMIGA Impulse Tracker"
DEPENDS = "gtk+ libgnomeui audiofile esound alsa-lib"
LICENSE = "GPL"
SECTION = "x11/multimedia"
PR = "r1"

SRC_URI = "http://mutab0r.chat.ru/soundtracker-0.6.7.gtk2.tar.bz2"
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
SRC_URI[md5sum] = "d2401a20f6922e5ce100d788d1688f0d"
SRC_URI[sha256sum] = "3c26e6e8daeab3e40b8b0a4459fa9215e420576e156476f6aaea15f0e156e023"

