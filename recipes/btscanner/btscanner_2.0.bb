DESCRIPTION = "Extract information from Bluetooth devices in range."
SECTION = "libs"
PRIORITY = "optional"
HOMEPAGE = "http://www.pentest.co.uk/cgi-bin/viewcat.cgi?cat=downloads&section=01_bluetooth"
DEPENDS = "bluez-libs gdbm ncurses libxml2"
PR = "r2"
LICENSE = "GPLv2"

SRC_URI = "http://www.pentest.co.uk/src/btscanner-${PV}.tar.bz2 \
           file://gcc-4.patch;patch=1 \
           file://configurable-paths.patch;patch=1 \
           "

FILES_${PN} += "${datadir}/oui.txt"

inherit autotools
