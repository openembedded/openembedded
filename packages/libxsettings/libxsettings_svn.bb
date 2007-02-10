DESCRIPTION = "Common code for XSETTINGS"
SECTION = "gpe/libs"
PRIORITY = "optional"
LICENSE = "BSD-X"
DEPENDS = "virtual/libx11"
PV = "0.11+svn${SRCDATE}"
PR = "r0"

inherit gpe

SRC_URI = "${GPE_SVN} \
           file://libxsettings-svn-makefile-fix.patch;patch=1 \
           file://Makefile.dpkg_ipkg \
           file://Makefile.translation"

S = "${WORKDIR}/${PN}"

do_install () {
        gpe_do_install
        oe_runmake PREFIX=${prefix} DESTDIR=${D} install-devel
}
do_stage () {
        oe_libinstall -so libXsettings ${STAGING_LIBDIR}
        mkdir -p ${STAGING_INCDIR}/gpe
        for h in ${headers}; do
                install -m 0644 ${S}/$h ${STAGING_INCDIR}/$h
        done
}

headers = "xsettings-common.h"

DEFAULT_PREFERENCE = "-1"
