SRC_URI = "http://64.34.161.181/download/1.5.0/sources/${P}.tar.gz"
inherit autotools
S = "${WORKDIR}/${PN}"

SRC_URI[md5sum] = "fe0d5e0e78b37725336b339ba7596d0b"
SRC_URI[sha256sum] = "5ba41f9f49b78f07cbad616acf1247baab2205f8b181083f6288c53ec9f6806c"
