SRC_URI = "http://64.34.161.181/download/1.5.0/sources/${P}.tar.gz"
inherit autotools
S = "${WORKDIR}/${PN}"

SRC_URI[md5sum] = "9432195d04bf226909bc5d68773657a3"
SRC_URI[sha256sum] = "63b978eb9567a46a60aba46d918be516d7b86dbeab21ab507e6ec22611683d9a"
