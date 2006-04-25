DESCRIPTION = "OpenPOBox is an open source implementation of a 'Predictive Operation Based On eXample'"
SECTION = "libs/inputmethods"
LICENSE = "GPL"
DEPENDS = "perl-native ruby-native"

BROKEN = "1"

SRC_URI = "http://pitecan.com/OpenPOBox/dist/pobox-${PV}.tgz \
           http://www.vanille.de/mirror/pbserver-${PV}.tar.gz \
           file://OpenPOBox-1.25.diff;patch=1"
S = "${WORKDIR}/OpenPOBox"

inherit autotools

EXTRA_OECONF = "--enable-lookup"
PARALLEL_MAKE = ""
