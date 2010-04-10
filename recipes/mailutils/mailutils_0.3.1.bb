SECTION = "console/network"
DESCRIPTION = "GNU Mailutils contains a series of \
useful mail clients, servers, and libraries."
LICENSE = "GPL LGPL"
SRC_URI = "${GNU_MIRROR}/mailutils/mailutils-${PV}.tar.bz2 \
	   file://configure.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--disable-pam --without-guile"

SRC_URI[md5sum] = "d2f0192b3dd95b33e764a0d480085cdd"
SRC_URI[sha256sum] = "1d145c55cf9ef1cd9ad996bd7efe0df7765e0ec8ef60a0b95f5c239172efebdd"
