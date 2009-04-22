DESCRIPTION = "Linknx is an automation platform providing high level functionalities to EIB/KNX installation. \
The rules engine allows execution of actions based on complex logical conditions and timers"
HOMEPAGE = "http://linknx.sourceforge.net/"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL"

DEPENDS = " pthsem "
DEPENDS_append_linux-uclibc = " argp-standalone"
DEPENDS_append_linux-uclibcgnueabi = " argp-standalone"

SRC_URI = "${SOURCEFORGE_MIRROR}/linknx/linknx-${PV}.tar.gz \
           file://configure-libcurl.patch;patch=1 "

inherit autotools

EXTRA_OECONF = " --with-pth=yes --without-pth-test --without-mysql --without-libcurl --without-log4cpp --without-lua"
