LICENSE = "GPL"
MAINTAINER = "Oyvind Repvik <nail@nslu2-linux.org>"
DESCRIPTION = "ShoutCast-compatible streamer"
PR = "r0"

SRC_URI = "http://www.litestream.org/litestream/${PN}-${PV}.tar.gz"

inherit autotools

do_install () {
	mkdir -p ${D}${bindir}
        install -m 755 litestream ${D}${bindir}
        install -m 755 literestream ${D}${bindir}
        install -m 755 source ${D}${bindir}
        install -m 755 client ${D}${bindir}
	install -m 755 server ${D}${bindir}
}