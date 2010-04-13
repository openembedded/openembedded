require microwindows.inc

SRC_URI = " \
  ftp://ftp.microwindows.org/pub/microwindows/microwindows-src-snapshot.tar.gz \
  file://defconfig \
  file://pagesize.patch;patch=1 \
  file://makefilerules.patch;patch=1 \
 "

S=${WORKDIR}/microwin

SRC_URI[md5sum] = "934348f3ccfb457f8faad0b17dc900cb"
SRC_URI[sha256sum] = "319d155e2032b97c799faaf0c47dca0a247b4f6893d6d92153600329af32c9b7"
#CHECKSUMS.INI MISMATCH: I've got this instead:
#SRC_URI[md5sum] = "822904ddd52963ad3f5297891a392076"
#SRC_URI[sha256sum] = "646a474d5c0a8f90ca63c5d69e667d8f9e12034cc5a3919c5bc38b1d2bd6c89c"
