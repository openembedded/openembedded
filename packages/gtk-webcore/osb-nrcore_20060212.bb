DESCRIPTION = "Gtk+ WebCore - rendering engine"
HOMEPAGE = "http://gtk-webcore.sourceforge.net/"
LICENSE = "GPL"
PRIORITY = "optional"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
SECTION = "gpe"

FIXEDSRCDATE = "${@bb.data.getVar('FILE', d, 1).split('_')[-1].split('.')[0]}"
PV = "0.5.0+cvs${FIXEDSRCDATE}"
PR = "r0"

DEPENDS = "glib-2.0 gtk+ pango osb-jscore"

SRC_URI = "cvs://anonymous@gtk-webcore.cvs.sourceforge.net/cvsroot/gtk-webcore;module=NRCore;date=${FIXEDSRCDATE} \
           file://KWIQ-mimetype-segfault.patch;patch=1 \
	   file://KWQKURL-urlcmp.patch;patch=1 \
           file://gcc4-fno-threadsafe-statics-NRCore.patch;patch=1"
S = "${WORKDIR}/NRCore"

DEFAULT_PREFERENCE = "${@['-1', '1'][not bb.data.getVar('PREFERRED_VERSION_gcc-cross', d, 1) or bb.data.getVar('PREFERRED_VERSION_gcc-cross', d, 1).split('.')[0] == '4']}"

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
