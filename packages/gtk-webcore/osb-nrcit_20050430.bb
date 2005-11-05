DESCRIPTION = "Gtk+ WebCore - NRCit embeddable browser component"
HOMEPAGE = "http://gtk-webcore.sourceforge.net/"
LICENSE = "nokia"
PRIORITY = "optional"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
SECTION = "gpe"

FIXEDCVSDATE = "${@bb.data.getVar('FILE', d, 1).split('_')[-1].split('.')[0]}"
PV = "0.5.0+cvs${FIXEDCVSDATE}"
PR = "r1"

DEPENDS = "curl librsvg osb-nrcore"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/gtk-webcore;module=NRCit;date=${FIXEDCVSDATE} \
           file://gdk-colorspace.diff;patch=1"
S = "${WORKDIR}/NRCit"

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
