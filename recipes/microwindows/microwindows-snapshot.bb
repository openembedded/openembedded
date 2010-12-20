require microwindows.inc

SRC_URI = " \
  ftp://ftp.microwindows.org/pub/microwindows/microwindows-src-snapshot.tar.gz \
  file://defconfig \
  file://pagesize.patch \
  file://makefilerules.patch \
 "

S=${WORKDIR}/microwin

SRC_URI[md5sum] = "039499d9dad2560da66d8916e7365dd7"
SRC_URI[sha256sum] = "781a5585e5be59c68cfcd944f5915d2238415d6f6d8f28d8742022ccb0746a92"

