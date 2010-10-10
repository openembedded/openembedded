DESCRIPTION = "Common code for XSETTINGS"
SECTION = "gpe/libs"
PRIORITY = "optional"
LICENSE = "BSD-X"
DEPENDS = "virtual/libx11"
PV = "0.11+svn${SRCDATE}"
PR = "r1"

inherit gpe

SRC_URI = "${GPE_SVN} \
           file://libxsettings-svn-makefile-fix.patch \
           file://Makefile.dpkg_ipkg \
           file://Makefile.translation"

S = "${WORKDIR}/${PN}"

headers = "xsettings-common.h"

do_install () {
        gpe_do_install
        oe_runmake PREFIX=${prefix} DESTDIR=${D} install-devel

        oe_libinstall -so libXsettings ${D}${libdir}
        install -d ${D}${includedir}/gpe
        for h in ${headers}; do
                install -m 0644 ${S}/$h ${D}${includedir}/$h
        done
}

DEFAULT_PREFERENCE = "-1"
