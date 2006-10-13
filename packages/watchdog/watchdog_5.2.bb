#CONFFILES = "${sysconfdir}/watchdog.conf"
DESCRIPTION = "Software watchdog"
LICENSE = "GPL"
PR = "r3"

SRC_URI = "http://www.ibiblio.org/pub/Linux/system/daemons/watchdog/${P}.tar.gz"
SRC_URI += "file://mkinstalldirs.patch;patch=1"

inherit autotools

FILES = "${sysconfdir}/watchdog.conf ${sbindir}/watchdog"
