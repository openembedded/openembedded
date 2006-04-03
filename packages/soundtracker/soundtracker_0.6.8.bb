DESCRIPTION = "Music composition program in the style of AMIGA Impulse Tracker"
HOMEPAGE = "http://www.soundtracker.org"
DEPENDS = "gtk+-1.2"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
SECTION = "x11/multimedia"
PR = "r0"

MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"

SRC_URI = "http://www.soundtracker.org/dl/v0.6/soundtracker-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = "--disable-asm"

do_configure() {
	oe_runconf
}

