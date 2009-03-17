S = "${WORKDIR}/ipkg-${PV}"

#require ipkg_${PV}.bb
require ipkg-native.inc
PR = "r6"

inherit autotools pkgconfig native

SRC_URI = "http://www.handhelds.org/pub/packages/ipkg/ipkg-${PV}.tar.gz \
           file://update_version_comparision.patch;patch=1 \
           file://enable_debversion.patch;patch=1 \
           file://is-processing.patch;patch=1 \
           file://1-pkg-parse--Optimize-inefficient-parsing.patch;patch=1 \
           file://2-pkg-vec--Optimize-gross-inefficiency.patch;patch=1 \
          "

