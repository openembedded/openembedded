DEPENDS =	"diet-x11"
LICENSE = 	"GPL"


SRC_URI = "http://64.34.161.181/download/1.5.0/sources/${P}.tar.gz"
inherit autotools
S = "${WORKDIR}/${PN}"
SRC_URI[md5sum] = "8608a76bb9852c9bea8aedeba5cd1158"
SRC_URI[sha256sum] = "02e6e966499da1237e3c97a2aef1335c1ee4fe80a91476fc67cbe08a310b50dd"
