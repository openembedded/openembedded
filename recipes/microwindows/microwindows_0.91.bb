require microwindows.inc

SRC_URI = " \
  ftp://ftp.microwindows.org/pub/microwindows/microwindows-src-${PV}.tar.gz \
  file://defconfig \
  file://pagesize.patch;patch=1 \
  file://staticwin.patch;patch=1 \
 "



SRC_URI[md5sum] = "901e912cf3975f6460a9bb4325557645"
SRC_URI[sha256sum] = "c0a8473842fc757ff4c225f82b83d98bba5da0dca0cf843cfc7792064a393435"
