DESCRIPTION = "tangoGPS map"
AUTHOR = "Marcus Bauer <marcus.bauer@gmail.com>"
HOMEPAGE = "http://tangogps.org/"
SECTION = "openmoko/pim"
PRIORITY = "optional"
LICENSE = "GPLv2"
DEPENDS = "curl gtk+ gpsd"
PR = "r1"

SRC_URI = "http://tangogps.org/tangoGPS-0.7.tar.gz \
           file://global-config-h.patch;patch=1"

S = "${WORKDIR}/tangoGPS-0.7"

inherit autotools
