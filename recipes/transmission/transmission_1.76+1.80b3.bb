require transmission.inc

SRC_URI = "http://mirrors.m0k.org/transmission/files/transmission-1.80b3.tar.bz2 \
           file://init \
           file://config \
"

S = "${WORKDIR}/transmission-1.80b3"

