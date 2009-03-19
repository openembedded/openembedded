DESCRIPTION = "G15daemon  takes control of the G15 keyboard, \
allowing the use of all keys through the linux kernel uinput \
device driver.  It  also controls  the use of the keyboard's \
LCD display, allows multiple, simultaneous client applications \
to connect, and gives  the  user the  ability to switch between \
client apps at the press of a button."
HOMEPAGE = "http://g15tools.sourceforge.net"
LICENSE = "GPLv2"
SECTION = "console/utils"
PRIORITY = "optional"
DEPENDS = "libdaemon libg15"
RDEPENDS = "libg15"
RRECOMMENDS = "kernel-module-uinput"
PR ="r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/g15daemon/g15daemon-${PV}.tar.bz2"

inherit autotools

EXTRA_OECONF = "--with-gnu-ld"

do_stage () {
	autotools_stage_all
}

