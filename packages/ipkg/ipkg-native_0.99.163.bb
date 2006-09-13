S = "${WORKDIR}/ipkg-${PV}"

#require ipkg_${PV}.bb
require ipkg-native.inc
PR = "r1"

inherit autotools pkgconfig native

SRC_URI = "http://www.handhelds.org/pub/packages/ipkg/ipkg-${PV}.tar.gz"

