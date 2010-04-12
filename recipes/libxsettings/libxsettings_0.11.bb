DESCRIPTION = "Common code for XSETTINGS"
SECTION = "gpe/libs"
LICENSE = "BSD-X"
PRIORITY = "optional"
DEPENDS = "virtual/libx11"

PR = "r1"

inherit gpe

headers = "xsettings-common.h"

do_compile_prepend() {
	sed -i -e 's: -s : :g' Makefile 
}

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

SRC_URI[md5sum] = "ea623deae839c41ef68c9a31233157ef"
SRC_URI[sha256sum] = "4cae17ea07445660cedb34a8a0222055954ed67de3d5a527850d8b9e923e3543"
