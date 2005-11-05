LICENSE = "LGPL"
DESCRIPTION = "Data interchange library for GPE"
SECTION = "gpe/libs"
PRIORITY = "optional"
MAINTAINER = "Philip Blundell <pb@handhelds.org>"
DEPENDS = "libmimedir"
PR = "r2"

inherit pkgconfig gpe

headers = "tag-db.h vcard.h vevent.h vtodo.h"

do_compile() {
	oe_runmake libgpevtype.so libgpevtype.pc
}

do_stage () {
	oe_libinstall -so libgpevtype ${STAGING_LIBDIR}

	mkdir -p ${STAGING_INCDIR}/gpe
	for h in ${headers}; do
		install -m 0644 ${S}/gpe/$h ${STAGING_INCDIR}/gpe/${h}
	done
}

do_install_append () {
        oe_runmake PREFIX='${prefix}' DESTDIR='${D}' install-devel
}

