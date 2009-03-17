require microwindows.inc

SRC_URI = " \
  ftp://ftp.microwindows.org/pub/microwindows/microwindows-src-snapshot.tar.gz \
  file://defconfig \
  file://pagesize.patch;patch=1 \
  file://makefilerules.patch;patch=1 \
 "

S=${WORKDIR}/microwin
