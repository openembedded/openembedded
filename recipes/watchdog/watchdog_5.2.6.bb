#CONFFILES = "${sysconfdir}/watchdog.conf"
DESCRIPTION = "Software watchdog"
LICENSE = "GPL"
PR = "r4"

SRC_URI = "http://www.ibiblio.org/pub/Linux/system/daemons/watchdog/${P}.tar.gz"

inherit autotools

FILES = "${sysconfdir}/watchdog.conf ${sbindir}/watchdog"
