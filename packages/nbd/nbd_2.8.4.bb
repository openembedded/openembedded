DESCRIPTION = "Network Block Device"
LICENSE = "GPLv2"
HOMEPAGE = "http://nbd.sourceforge.net"
MAINTAINER = "Holger Freyther <freyther@handhelds.org>"

DEPENDS = "glib-2.0"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.bz2;md5sum=1b5a0866d025b98d1c24fe19a4f628c3 \
           file://cross-compile.patch;patch=1 "

inherit autotools


PACKAGES = "nbd-client nbd-server"
PACKAGES += "nbd-client-doc nbd-server-doc"

FILES_nbd-client = "/usr/sbin/nbd-client"
FILES_nbd-server = "/usr/bin/nbd-server"
FILES_nbd-client-doc = "/usr/share/man/man8/*"
FILES_nbd-server-doc = "/usr/share/man/man1/*"
