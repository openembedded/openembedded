LICENSE = "LGPL"
DESCRIPTION = "Gtk+ display migration library"
DEPENDS = "gtk+ libgcrypt"
SECTION = "gpe"
PRIORITY = "optional"
PR = "r1"

inherit pkgconfig gpe

SRC_URI += "file://makefile-fix.patch;patch=1"

headers = "displaymigration.h auth.h crypt.h"

do_install() {
        oe_runmake PREFIX=${prefix} DESTDIR=${D} install
        oe_runmake PREFIX=${prefix} DESTDIR=${D} install-devel
}

do_stage () {
	oe_libinstall -so libdisplaymigration ${STAGING_LIBDIR}

	mkdir -p ${STAGING_INCDIR}/libdisplaymigration
	for h in ${headers}; do
		install -m 0644 ${S}/libdisplaymigration/$h ${STAGING_INCDIR}/libdisplaymigration/${h}
	done
}

SRC_URI[md5sum] = "f976234f9dfd6a8e1288710b49d29964"
SRC_URI[sha256sum] = "f776abe417432b3c4ff8b063201c4b4b45479a563fb43e6fd64504b538ef4689"
