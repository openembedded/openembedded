DESCRIPTION = "Gtk+ WebCore - NRCit embeddable browser component"
HOMEPAGE = "http://gtk-webcore.sourceforge.net/"
LICENSE = "nokia"
PRIORITY = "optional"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
SECTION = "gpe"

FIXEDSRCDATE = "${@bb.data.getVar('FILE', d, 1).split('_')[-1].split('.')[0]}"
PV = "0.5.0+cvs${FIXEDSRCDATE}"
PR = "r0"

DEPENDS = "curl librsvg osb-nrcore"

SRC_URI = "cvs://anonymous@gtk-webcore.cvs.sourceforge.net/cvsroot/gtk-webcore;module=NRCit;date=${FIXEDSRCDATE} \
           file://stop-load.image-loading.patch;patch=1 \
           file://gcc4-fno-threadsafe-statics-NRCit.patch;patch=1"
S = "${WORKDIR}/NRCit"

DEFAULT_PREFERENCE = "${@['-1', '1'][not bb.data.getVar('PREFERRED_VERSION_gcc-cross', d, 1) or bb.data.getVar('PREFERRED_VERSION_gcc-cross', d, 1).split('.')[0] == '4']}"

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
