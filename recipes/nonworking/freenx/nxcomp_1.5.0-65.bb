LICENSE =	"GPL"
DEPENDS =	"zlib diet-x11 xproto"

SRC_URI = 	"http://64.34.161.181/download/1.5.0/sources/${P}.tar.gz"
inherit autotools


S = 		"${WORKDIR}/${PN}"
SRC_URI[md5sum] = "cab094a88acb299cc1e89dfb2c6a95eb"
SRC_URI[sha256sum] = "cbaa4c39db887e2f180a2784faf15f5a945a38931db81f8541fffb3a1818ff2d"
