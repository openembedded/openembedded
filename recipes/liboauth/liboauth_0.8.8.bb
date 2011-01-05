DESCRIPTION = "Collection of POSIX-c functions implementing the OAuth Core RFC 5849 standard"
HOMEPAGE = "http://liboauth.sourceforge.net/"
LICENSE = "MIT GPLv2"
DEPENDS = "curl"
SECTION = "libs"

SRC_URI = "http://liboauth.sourceforge.net/pool/${P}.tar.gz"
SRC_URI[md5sum] = "3c6b0d74c1e469c307ea7962044fdb9a"
SRC_URI[sha256sum] = "f5079670c08206a2bb28482934c59994cf1a288d3ec279d9a3723c4941230fd7"

inherit autotools
