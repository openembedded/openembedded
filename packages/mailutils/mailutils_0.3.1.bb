SECTION = "console/network"
DESCRIPTION = "GNU Mailutils contains a series of \
useful mail clients, servers, and libraries."
LICENSE = "GPL LGPL"
SRC_URI = "${GNU_MIRROR}/mailutils/mailutils-${PV}.tar.bz2 \
	   file://configure.patch;patch=1"

inherit autotools 

EXTRA_OECONF = "--disable-pam --without-guile"
