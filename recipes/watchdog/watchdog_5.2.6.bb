#CONFFILES = "${sysconfdir}/watchdog.conf"
DESCRIPTION = "Software watchdog"
LICENSE = "GPL"
PR = "r4"

SRC_URI = "http://www.ibiblio.org/pub/Linux/system/daemons/watchdog/${P}.tar.gz"

inherit autotools

FILES = "${sysconfdir}/watchdog.conf ${sbindir}/watchdog"

SRC_URI[md5sum] = "5a1a4476087973852e30f8cdb5b0ff92"
SRC_URI[sha256sum] = "c762525fdbf5f5dd32c6c950f2a63d8c1b15ec3dc7afca5d2dc3dbd1b129a00d"
