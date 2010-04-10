require transmission.inc

SRC_URI = "http://mirrors.m0k.org/transmission/files/transmission-1.80b4.tar.bz2 \
           file://init \
           file://config \
"

S = "${WORKDIR}/transmission-1.80b4"


SRC_URI[md5sum] = "8a257189b51bd3608a8478680230e716"
SRC_URI[sha256sum] = "c7dc1627e21a5f1625ce4958e247a44fb8b13ce8733085c1d64707bd93ed9178"
