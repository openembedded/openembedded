DESCRIPTION = "Gtk+ WebCore - NRCit embeddable browser component"
LICENSE = "nokia"
HOMEPAGE = "http://gtk-webcore.sourceforge.net/"
PRIORITY = "optional"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
DEPENDS = "curl osb-nrcore"
SECTION = "gpe"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/gtk-webcore/osb-nrcit-${PV}.tar.gz"

inherit autotools pkgconfig

do_configure () {
	autotools_do_configure
	cd ${S}

	# prevent libtool from linking libs against libstdc++, libgcc, ...
	cat ${TARGET_PREFIX}libtool | sed -e 's/postdeps=".*"/postdeps=""/' > ${TARGET_PREFIX}libtool.tmp
	mv ${TARGET_PREFIX}libtool.tmp ${TARGET_PREFIX}libtool
}

do_stage () {
	oe_libinstall -so -C src libnrcit ${STAGING_LIBDIR}

	autotools_stage_includes
	
	install -d ${STAGING_INCDIR}/osb
	install -m 0644 ${S}/src/gtk/gtk-khtml.h ${STAGING_INCDIR}/osb
	install -m 0644 ${S}/src/osb.h ${STAGING_INCDIR}/osb
}
