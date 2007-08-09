DESCRIPTION = "Tor is a network of virtual tunnels that allows people and groups \
              to improve their privacy and security on the Internet."
HOMEPAGE = "http://tor.eff.org"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "BSD"
DEPENDS = "libevent openssl zlib"

SRC_URI = "http://tor.eff.org/dist/${P}.tar.gz \
          file://configure.patch;patch=1;pnum=1 \
          file://make.patch;patch=1;pnum=1 \
          file://compat.patch;patch=1;pnum=1 \
          file://tor.init"


inherit autotools update-rc.d

INITSCRIPT_NAME = "tor"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install ${WORKDIR}/tor.init ${D}${sysconfdir}/init.d/tor
}
