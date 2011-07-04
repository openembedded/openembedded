DESCRIPTION = "Tor is a network of virtual tunnels that allows people and groups \
              to improve their privacy and security on the Internet."
HOMEPAGE = "http://tor.eff.org"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "BSD"
DEPENDS = "libevent openssl zlib"

SRC_URI = "http://tor.eff.org/dist/${P}.tar.gz \
           file://tor.init"

inherit autotools update-rc.d

INITSCRIPT_NAME = "tor"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install ${WORKDIR}/tor.init ${D}${sysconfdir}/init.d/tor
}

SRC_URI[md5sum] = "6c6d61e053af5969a245d025c4cfce9d"
SRC_URI[sha256sum] = "f352a1a8ffa469ae251324f89386074074bcffef1a7c6a72caa7e4c2d12ce109"

