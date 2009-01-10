require microwindows.inc

SRC_URI = " \
  ftp://ftp.microwindows.org/pub/microwindows/microwindows-${PV}.tar.gz \
  file://defconfig \
  file://pagesize.patch;patch=1 \
  file://nochown.patch;patch=1 \
 "


