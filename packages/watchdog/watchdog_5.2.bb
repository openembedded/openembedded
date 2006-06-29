DESCRIPTION = "Software watchdog"
MAINTAINER = "Oyvind Repvik <nail@nslu2-linux.org>"
PR = "r3"
LICENSE = "GPL"

SRC_URI = "http://www.ibiblio.org/pub/Linux/system/daemons/watchdog/${PN}-${PV}.tar.gz"

SRC_URI += "file://mkinstalldirs.patch;patch=1"

FILES = "${sysconfdir}/watchdog.conf ${sbindir}/watchdog"
#CONFFILES = "${sysconfdir}/watchdog.conf"

inherit autotools

