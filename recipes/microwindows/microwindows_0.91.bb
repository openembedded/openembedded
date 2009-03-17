require microwindows.inc

SRC_URI = " \
  ftp://ftp.microwindows.org/pub/microwindows/microwindows-src-${PV}.tar.gz \
  file://defconfig \
  file://pagesize.patch;patch=1 \
  file://staticwin.patch;patch=1 \
 "


