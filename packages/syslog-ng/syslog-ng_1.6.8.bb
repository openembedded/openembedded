PR = "r2"
MAINTAINER = "Oyvind Repvik <nail@nslu2-linux.org"

SRC_URI = "http://www.balabit.com/downloads/syslog-ng/1.6/src/${PN}-${PV}.tar.gz"

S = "${WORKDIR}/${PN}-${PV}"
inherit autotools

EXTRA_OECONF = "--with-libol=${STAGING_BINDIR}/"
