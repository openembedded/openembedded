DESCRIPTION = "A GUI frontend for playing various chess engines and from the internet"
HOMEPAGE = "http://www.tim-mann.org/xboard.html"
SECTION = "games"
LICENSE = "GPL"
DEPENDS = "libxaw libsm libx11 libxt libxmu libxext libice"
SRC_URI = "http://ftp.gnu.org/gnu/${PN}/${P}.tar.gz"

SRC_URI[md5sum] = "06a2d921650718ea272e7c0ec957dccc"
SRC_URI[sha256sum] = "33297c170fca99d10b53ba8f6bebdfa65ac69c918358299e96156456f2b4d5a9"

inherit autotools

FILES_${PN} += "${datadir}/icons"
