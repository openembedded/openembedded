LICENSE = GPL
DESCRIPTION = "Gtk+ WebCore - rendering engine"
HOMEPAGE = "http://gtk-webcore.sourceforge.net/"
PRIORITY = "optional"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
DEPENDS = "glib-2.0 gtk+ pango osb-jscore"
SECTION = "gpe"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/gtk-webcore/osb-nrcore-${PV}.tar.gz \
           file://KWQDictImpl.patch;patch=1"

LEAD_SONAME = "libnrcore.so"

inherit autotools pkgconfig

do_configure () {
	autotools_do_configure
	cd ${S}

	# prevent libtool from linking libs against libstdc++, libgcc, ...
	cat ${TARGET_PREFIX}libtool | sed -e 's/postdeps=".*"/postdeps=""/' > ${TARGET_PREFIX}libtool.tmp
	mv ${TARGET_PREFIX}libtool.tmp ${TARGET_PREFIX}libtool
}

do_stage () {
	oe_libinstall -so libnrcore ${STAGING_LIBDIR}
	oe_libinstall -so -C kwiq libnrcore_kwiq_gtk ${STAGING_LIBDIR}

	autotools_stage_includes
	
	install -d ${STAGING_INCDIR}/osb/NRCore
	for i in ${S}/kwiq/WebCore*.h ${S}/kwiq/KWIQ*.h; do
		install -m 0644 $i ${STAGING_INCDIR}/osb/NRCore
	done
}
