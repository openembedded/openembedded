DESCRIPTION = "A cross platform audio visualization library"
HOMEPAGE = "http://libvisual.sf.net"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL"
# FIXME: current depends dont support versioned deps well
# DEPENDS = "libvisual (${PV})"
DEPENDS = "libvisual"

SRC_URI = "${SOURCEFORGE_MIRROR}/libvisual/libvisual-plugins-${PV}.tar.gz"

inherit autotools

FILES_${PN} += "${libdir}/libvisual/actor/*.so ${libdir}/libvisual/morph/*.so"

SRC_URI[md5sum] = "9c3012e7a648540ac8c7053a0801830f"
SRC_URI[sha256sum] = "7f681c64c5940a757a636281915d170d715fc4936e294052957f635ea1af0d67"
