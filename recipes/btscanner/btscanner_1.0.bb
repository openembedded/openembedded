DESCRIPTION = "Extract information from Bluetooth devices in range."
SECTION = "libs"
PRIORITY = "optional"
HOMEPAGE = "http://www.pentest.co.uk/cgi-bin/viewcat.cgi?cat=downloads&section=01_bluetooth"
DEPENDS = "bluez-libs gdbm ncurses"
PR = "r3"
LICENSE = "GPLv2"

SRC_URI = "http://www.pentest.co.uk/src/btscanner-${PV}.tar.gz \
	   file://0909132213173.patch;patch=1 \
	   file://configure.patch;patch=1"

#Yes, the packages uses this ugly hardcoded path instead of ${sysconfdir}
FILES_${PN} += "/usr/etc/oui.txt"

inherit autotools

SRC_URI[md5sum] = "6bfaaad5a3730f10d07500fb3ec8c797"
SRC_URI[sha256sum] = "ca7349c3621c929f9fda0345991b35f8a0d38d4a88b6c89b7ca50a7dbcc08832"
