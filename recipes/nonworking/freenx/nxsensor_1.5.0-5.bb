SRC_URI = "http://64.34.161.181/download/1.5.0/sources/${P}.tar.gz"
inherit autotools
S = "${WORKDIR}/${PN}"

SRC_URI[md5sum] = "96606ac35ef59c1492c6cc9158088f88"
SRC_URI[sha256sum] = "60fbdb5784b1049680c2f18401f092594c6aab5d4051ce0f414b62f2cb685ce6"
