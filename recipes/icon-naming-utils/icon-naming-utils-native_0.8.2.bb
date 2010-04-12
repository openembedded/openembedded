LICENSE = "GPLv2"
DEPENDS = "libxml-simple-perl-native"
PR = "r1"

SRC_URI = "http://tango.freedesktop.org/releases/icon-naming-utils-0.8.2.tar.gz"

S = "${WORKDIR}/icon-naming-utils-${PV}"

inherit autotools native

SRC_URI[md5sum] = "76e6afde567bd17b4fe095aa0ec90531"
SRC_URI[sha256sum] = "87fe398d5f4853400afb6afbb41835db3cde954845369e406d739d66b3058056"
