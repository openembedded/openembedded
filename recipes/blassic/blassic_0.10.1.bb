DESCRIPTION = "classic basic interpreter"
LICENSE = "GPLv2"
DEPENDS = "ncurses"

SRC_URI = "http://www.blassic.org/bin/blassic-${PV}.tgz"

inherit autotools pkgconfig

EXTRA_OECONF = "--enable-graphics=yes"



SRC_URI[md5sum] = "ca1339d71c8bf2779613afefc5384b0a"
SRC_URI[sha256sum] = "61e6e02a86d2da53e407b0a3724ed554fe2c85bab6775ae68e2e92a83e466406"
