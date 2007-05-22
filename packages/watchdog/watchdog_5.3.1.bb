#CONFFILES = "${sysconfdir}/watchdog.conf"
DESCRIPTION = "Software watchdog"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://www.ibiblio.org/pub/Linux/system/daemons/watchdog/${PN}_${PV}.tar.gz"

inherit autotools

FILES = "${sysconfdir}/watchdog.conf ${sbindir}/watchdog"
