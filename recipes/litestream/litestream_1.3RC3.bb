LICENSE = "GPL"
DESCRIPTION = "ShoutCast-compatible streamer"
PR = "r0"

SRC_URI = "http://www.litestream.org/litestream/${P}.tar.gz"

inherit autotools

do_install () {
        install -d ${D}${bindir}
        install -m 755 litestream ${D}${bindir}
        install -m 755 literestream ${D}${bindir}
        install -m 755 source ${D}${bindir}
        install -m 755 client ${D}${bindir}
        install -m 755 server ${D}${bindir}
}

SRC_URI[md5sum] = "68698f62d9eb9e620501f31c6f9acc42"
SRC_URI[sha256sum] = "ee3edf1ea89a90f2b7f82ad09b83c25dc8ea8ca7cf0fce2aa921f897929b2bb9"
