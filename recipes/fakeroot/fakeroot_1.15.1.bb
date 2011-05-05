require fakeroot.inc
PR = "${INC_PR}.0"

SRC_URI =+ "\
  ${DEBIAN_MIRROR}/main/f/fakeroot/fakeroot_${PV}.orig.tar.bz2 \
  file://quiet-getopt-check.patch \
"

SRC_URI[md5sum] = "248c408b1e06e776c5739871b49bd968"
SRC_URI[sha256sum] = "45fbb9ad611f33224cc09954963dde563cc80fe58c76feb25b6e98550b81729a"
