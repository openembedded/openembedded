SECTION = "gpe/libs"
LICENSE = "BSD-X"
PRIORITY = "optional"
DEPENDS = "libgpewidget libxsettings x11"

inherit pkgconfig gpe

SRC_URI += "file://make_pkgconfig_x11.patch;patch=1"

headers = "xsettings-client.h"
do_stage () {
        oe_libinstall -so libXsettings-client ${STAGING_LIBDIR}
        mkdir -p ${STAGING_INCDIR}
        for h in ${headers}; do
                install -m 0644 ${S}/$h ${STAGING_INCDIR}/$h
        done
}

do_install () {
        gpe_do_install
        oe_runmake PREFIX=${prefix} DESTDIR=${D} install-devel
}
