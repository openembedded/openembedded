SECTION = "gpe/libs"
LICENSE = "BSD-X"
PRIORITY = "optional"
DEPENDS = "libxsettings libx11 libxt"
# libxt is required to stop configure breaking builds by 
# including system paths to find it if it isn't present.
MAINTAINER = "Florian Boor <florian@kernelconcepts.de>"
PR="r0"

GPE_TARBALL_SUFFIX = "bz2"
inherit autotools pkgconfig gpe


headers = "xsettings-client.h xsettings-common.h"
do_stage () {
        oe_libinstall -so libXsettings-client ${STAGING_LIBDIR}
        mkdir -p ${STAGING_INCDIR}
        for h in ${headers}; do
               install -m 0644 ${S}/$h ${STAGING_INCDIR}/$h
        done
}

