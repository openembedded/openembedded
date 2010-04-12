SRC_URI = "http://64.34.161.181/download/1.5.0/sources/${P}.tar.gz"
inherit autotools
S = "${WORKDIR}/${PN}"

SRC_URI[md5sum] = "a7c5e68e9678cb5c722c334b33baf660"
SRC_URI[sha256sum] = "42549f5767627378653d11f1d16d7334a6e08f3b1ecdd5edd0188aaaa7c36e4d"
