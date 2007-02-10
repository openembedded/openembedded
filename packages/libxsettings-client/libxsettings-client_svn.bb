SECTION = "gpe/libs"
PRIORITY = "optional"
LICENSE = "BSD-X"
DEPENDS = "libxsettings virtual/libx11 libxt gtk-doc"
PV = "0.17+svn${SRCDATE}"
# libxt is required to stop configure breaking builds by
# including system paths to find it if it isn't present.
PR = "r0"

inherit autotools pkgconfig gpe

SRC_URI = "${GPE_SVN}"

S = "${WORKDIR}/${PN}"

do_stage () {
        oe_libinstall -so libXsettings-client ${STAGING_LIBDIR}
        mkdir -p ${STAGING_INCDIR}
        for h in ${headers}; do
               install -m 0644 ${S}/$h ${STAGING_INCDIR}/$h
        done
}

headers = "xsettings-client.h xsettings-common.h"

DEFAULT_PREFERENCE = "-1"
