SECTION = "gpe/libs"
LICENSE = "BSD-X"
PRIORITY = "optional"
DEPENDS = "libgpewidget libxsettings virtual/libx11"

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

SRC_URI[md5sum] = "6a9d49b146abafcc9a7e67baed800cf6"
SRC_URI[sha256sum] = "3e9f5e5e61611e8df234aedd48286407ae57e40e8f6e6499eb66accb09d6b5c4"
