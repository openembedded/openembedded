require microwindows.inc

SRC_URI = " \
  ftp://ftp.microwindows.org/pub/microwindows/microwindows-${PV}.tar.gz \
  file://defconfig \
  file://pagesize.patch;patch=1 \
  file://nochown.patch;patch=1 \
 "



SRC_URI[md5sum] = "203188db254cc418e9d9dd9791543b9a"
SRC_URI[sha256sum] = "8253a341c3bdd49467ecfdb5ccc03b359eacec5aec0b35bd77cdce341e157399"
