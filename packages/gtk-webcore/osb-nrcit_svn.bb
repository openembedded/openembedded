DESCRIPTION = "Gtk+ WebCore - NRCit embeddable browser component"
HOMEPAGE = "http://gtk-webcore.sourceforge.net/"
LICENSE = "nokia"
PRIORITY = "optional"
SECTION = "gpe"

PV = "0.5.2+svn${SRCDATE}"
PR = "r0"

DEPENDS = "curl librsvg osb-nrcore"

SRC_URI = "svn://gtk-webcore.svn.sourceforge.net/svnroot/gtk-webcore/trunk;module=NRCit;proto=https \
	   file://NRCit_unmap.diff;patch=1 \
           file://NRCit_HTTP_auth.diff;patch=1 \  
           file://gcc4-fno-threadsafe-statics-NRCit.patch;patch=1"
S = "${WORKDIR}/NRCit"

DEFAULT_PREFERENCE = "-1"

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
