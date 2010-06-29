SECTION = "gpe/libs"
LICENSE = "BSD-X"
PRIORITY = "optional"
DEPENDS = "libxsettings virtual/libx11 libxt"
RDEPENDS_${PN}-dev += " libxsettings-dev"
# libxt is required to stop configure breaking builds by
# including system paths to find it if it isn't present.

GPE_TARBALL_SUFFIX = "bz2"
inherit autotools pkgconfig gpe

INC_PR = "r3"

SRC_URI = "${GPE_MIRROR}/libxsettings-client-${PV}.tar.bz2 \
"

headers = "xsettings-client.h"
do_stage () {
        oe_libinstall -so libXsettings-client ${STAGING_LIBDIR}
        mkdir -p ${STAGING_INCDIR}
        for h in ${headers}; do
               install -m 0644 ${S}/$h ${STAGING_INCDIR}/$h
        done
}

do_install_append () {
	rm ${D}/${includedir}/xsettings-common.h
}
