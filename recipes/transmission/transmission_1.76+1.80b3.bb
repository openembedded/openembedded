require transmission.inc

SRC_URI = "http://mirrors.m0k.org/transmission/files/transmission-1.80b3.tar.bz2 \
           file://init \
           file://config \
"

S = "${WORKDIR}/transmission-1.80b3"


SRC_URI[md5sum] = "0b9cf68b68ce04d2e91723e3190c0568"
SRC_URI[sha256sum] = "6ffff2365e0508fd0e190054f2d57893b8755be8ce4a34e7ef89861c06033eb9"
