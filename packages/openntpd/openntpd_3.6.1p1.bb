DEPENDS += "openssl"
DESCRIPTION = "OpenNTPD is a FREE, easy to use implementation of the \
Network Time Protocol."
HOMEPAGE = "http://www.openntpd.org/"
LICENSE = "BSD"
SECTION = "console/network"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"

SRC_URI = "ftp://ftp.openbsd.org/pub/OpenBSD/OpenNTPD/openntpd-${PV}.tar.gz \
	   file://autofoo.patch;patch=1"
S = "${WORKDIR}/openntpd-${PV}"

inherit autotools

EXTRA_OECONF += "--disable-strip"
