DESCRIPTION = "Music composition program in the style of AMIGA Impulse Tracker"
HOMEPAGE = "http://www.soundtracker.org"
DEPENDS = "gtk+-1.2"
LICENSE = "GPL"
SECTION = "x11/multimedia"
PR = "r0"


SRC_URI = "http://www.soundtracker.org/dl/v0.6/soundtracker-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = "--disable-asm"

do_configure() {
	oe_runconf
}


SRC_URI[md5sum] = "1e5a2ef689e214933e53f687b3a199bb"
SRC_URI[sha256sum] = "03b2f2c0edba48457ec6178b0a10edfe3481254112936715603a21f638822f50"
