DESCRIPTION = "Music composition program in the style of AMIGA Impulse Tracker"
DEPENDS = "gtk+-1.2"
LICENSE = "GPL"
SECTION = "x11/multimedia"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
SRC_URI = "http://www.soundtracker.org/dl/v0.6/soundtracker-${PV}.tar.gz \
           file://remove-chown.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--disable-asm"

do_configure() {
	oe_runconf
}

