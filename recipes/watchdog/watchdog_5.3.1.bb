DESCRIPTION = "System watchdog daemon"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://www.ibiblio.org/pub/Linux/system/daemons/watchdog/${PN}_${PV}.tar.gz"

inherit autotools

FILES = "${sysconfdir}/watchdog.conf ${sbindir}/watchdog"

SRC_URI[md5sum] = "ba97ddce396bfccd8d409bc3141d7ef4"
SRC_URI[sha256sum] = "b7bf9feeedea26d7e06935369a1a556089426e94f9ead946018526c96cd9b12e"
