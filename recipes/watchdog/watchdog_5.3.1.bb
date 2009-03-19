DESCRIPTION = "System watchdog daemon"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://www.ibiblio.org/pub/Linux/system/daemons/watchdog/${PN}_${PV}.tar.gz"

inherit autotools

FILES = "${sysconfdir}/watchdog.conf ${sbindir}/watchdog"
