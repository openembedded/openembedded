LICENSE = "GPLv2"
DEPENDS = "libxml-simple-perl-native"

SRC_URI = "http://tango.freedesktop.org/releases/icon-naming-utils-${PV}.tar.gz"

S = "${WORKDIR}/icon-naming-utils-${PV}"

inherit autotools native

SRC_URI[md5sum] = "4abe604721ce2ccb67f451aa7ceb44d6"
SRC_URI[sha256sum] = "1cb49ce6a04626939893a447da696f20003903d61bd80c6d74d29dd79ca340d2"
