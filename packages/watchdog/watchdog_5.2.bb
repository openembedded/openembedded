#CONFFILES = "${sysconfdir}/watchdog.conf"
DESCRIPTION = "Software watchdog"
MAINTAINER = "Oyvind Repvik <nail@nslu2-linux.org>"
LICENSE = "GPL"
PR = "r3"

SRC_URI = "http://www.ibiblio.org/pub/Linux/system/daemons/watchdog/${PN}-${PV}.tar.gz"
SRC_URI += "file://mkinstalldirs.patch;patch=1"

inherit autotools

FILES = "${sysconfdir}/watchdog.conf ${sbindir}/watchdog"
