SECTION = "gpe/libs"
LICENSE = "BSD-X"
PRIORITY = "optional"
DEPENDS = "libxsettings virtual/libx11 libxt"
RDEPENDS_${PN}-dev += " libxsettings-dev"
# libxt is required to stop configure breaking builds by
# including system paths to find it if it isn't present.

GPE_TARBALL_SUFFIX = "bz2"
inherit autotools pkgconfig gpe

INC_PR = "r4"

SRC_URI = "${GPE_MIRROR}/libxsettings-client-${PV}.tar.bz2"

headers = "xsettings-client.h"

do_install () {
        oe_libinstall -so libXsettings-client ${D}${libdir}
        install -d ${D}${includedir}
        for h in ${headers}; do
               install -m 0644 ${S}/$h ${D}${includedir}/$h
        done
}
