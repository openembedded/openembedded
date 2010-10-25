DESCRIPTION = "C++ parsing library for Service Information (SI) in DVB systems"
AUTHOR = "Andreas Oberritter"
SECTION = "libs/multimedia"
PRIORITY = "optional"
LICENSE = "LGPLv2.1"

SRC_URI = "http://www.saftware.de/${PN}/${P}.tar.bz2"
SRC_URI[md5sum] = "78f19f665fe3399eb8bc97cd6ca7738c"
SRC_URI[sha256sum] = "2dfd9f588f639664f22afc794a173a0c36bb8ebd81615b0f192eefcb60e23480"

inherit autotools pkgconfig
