SRC_URI = "http://64.34.161.181/download/1.5.0/sources/${P}.tar.gz"
inherit autotools
S = "${WORKDIR}/${PN}"

SRC_URI[md5sum] = "920b4debd9006b759c2dc7fa49827b9d"
SRC_URI[sha256sum] = "39f5b11b9fa7e33b8bb065975b415eef78a0b9c5e20e748661bb3905a070d434"
