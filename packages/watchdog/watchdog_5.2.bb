DESCRIPTION = "Software watchdog"
MAINTAINER = "Oyvind Repvik <nail@nslu2-linux.org>"
PR = "r1"

SRC_URI = "http://www.ibiblio.org/pub/Linux/system/daemons/watchdog/${PN}-${PV}.tar.gz"
FILES = "${sysconfdir}/watchdog.conf ${sbindir}/watchdog"
CONFFILES = "${sysconfdir}/watchdog.conf"

inherit autotools

