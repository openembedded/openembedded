S = "${WORKDIR}/ipkg-${PV}"

include ipkg_${PV}.bb
include ipkg-native.inc

inherit autotools pkgconfig native

SRC_URI = "http://ftp.handhelds.org/pub/packages/ipkg/ipkg-${PV}.tar.gz"

