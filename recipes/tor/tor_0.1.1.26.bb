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

SRC_URI[md5sum] = "0667df7a1f670bee5163b607aea172ba"
SRC_URI[sha256sum] = "3be8c89be5b927e73b77a82ca3d83f0f162fceea2d6a14ce1c0cf5333b36cd1c"
