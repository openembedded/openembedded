LICENSE	=	""

DEPENDS =	"nxcomp"

SRC_URI = 	"http://64.34.161.181/download/1.5.0/sources/${P}.tar.gz"

inherit autotools
S = "${WORKDIR}/${PN}"

SRC_URI[md5sum] = "d2e3c1a109db336dfa497f4c2004f2d5"
SRC_URI[sha256sum] = "33227370c90cdb5e65824001255f4df5a20eecff19f75483df21bf55ab888d4a"
