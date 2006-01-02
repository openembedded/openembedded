DESCRIPTION = "Extract information from Bluetooth devices in range."
SECTION = "libs"
PRIORITY = "optional"
HOMEPAGE = "http://www.pentest.co.uk/cgi-bin/viewcat.cgi?cat=downloads&section=01_bluetooth"
DEPENDS = "bluez-libs gdbm ncurses"
PR = "r0"
LICENSE = "GPLv2"

SRC_URI = "http://www.pentest.co.uk/src/btscanner-${PV}.tar.bz2"

#Yes, the packages uses this ugly hardcoded path instead of ${sysconfdir}
FILES_${PN} += "/usr/share/oui.txt"

inherit autotools
