SRC_URI = "http://64.34.161.181/download/1.5.0/sources/${P}.tar.gz"
inherit autotools
S = "${WORKDIR}/${PN}"

SRC_URI[md5sum] = "fb53d2e1550778f80b5ecc8c59ff0182"
SRC_URI[sha256sum] = "b78a0655e495e63a50fff3bc53a4e71296e96b37f37e465b959a2a4f2e2a6234"
