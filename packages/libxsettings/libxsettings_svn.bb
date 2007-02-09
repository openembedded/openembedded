DESCRIPTION = "Common code for XSETTINGS"
MAINTAINER = "Philippe De Swert <philippedeswert@scarlet.be>"
SECTION = "gpe/libs"
LICENSE = "BSD-X"
PRIORITY = "optional"
DEPENDS = "virtual/libx11"
PR          = "r0"
PV = "0.11+svn${SRCDATE}"

DEFAULT_PREFERENCE = "-1"

inherit gpe

SRC_URI = "svn://projects.linuxtogo.org/svn/gpe/trunk/base;module=${PN} \
           file://libxsettings-svn-makefile-fix.patch;patch=1 \
	   file://Makefile.dpkg_ipkg \
	   file://Makefile.translation"

S = "${WORKDIR}/${PN}"

headers = "xsettings-common.h"

do_stage () {
        oe_libinstall -so libXsettings ${STAGING_LIBDIR}

	mkdir -p ${STAGING_INCDIR}/gpe
	for h in ${headers}; do
		install -m 0644 ${S}/$h ${STAGING_INCDIR}/$h
	done
}

do_install () {
	gpe_do_install
	oe_runmake PREFIX=${prefix} DESTDIR=${D} install-devel
}
