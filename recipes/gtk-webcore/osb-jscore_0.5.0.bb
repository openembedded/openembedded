LICENSE = "GPL"
DESCRIPTION = "Gtk+ WebCore - JavaScriptCore"
HOMEPAGE = "http://gtk-webcore.sourceforge.net/"
PRIORITY = "optional"
SECTION = "gpe"
PR = "r3"

SRC_URI = "${SOURCEFORGE_MIRROR}/gtk-webcore/osb-jscore-${PV}.tar.gz \
           file://missing-includes.patch;patch=1 \
           file://libm.patch;patch=1"

SRC_URI_append_sh3 = " file://superh-aclocal.patch;patch=1 \
                       file://gcc4-fno-threadsafe-statics.patch;patch=1 \
		       file://superh-ustring-declaration-error.patch;patch=1"

inherit autotools pkgconfig

do_configure () {
	autotools_do_configure
	cd ${S}

	# prevent libtool from linking libs against libstdc++, libgcc, ...
	cat ${TARGET_PREFIX}libtool | sed -e 's/postdeps=".*"/postdeps=""/' > ${TARGET_PREFIX}libtool.tmp
	mv ${TARGET_PREFIX}libtool.tmp ${TARGET_PREFIX}libtool
}

do_stage () {
	oe_libinstall -so -C kjs libjscore ${STAGING_LIBDIR}

	autotools_stage_includes

	install -d ${STAGING_INCDIR}/osb/JavaScriptCore
	for i in ${S}/kjs/*.h ${S}/kjs/new; do
		install -m 0644 $i ${STAGING_INCDIR}/osb/JavaScriptCore
	done
}

SRC_URI[md5sum] = "969cda923c419e35a319911b30b1d4b8"
SRC_URI[sha256sum] = "f5ad6961288687b8dc44a3f5cd6d1901b1b5b293e592da7a63c201eee1089464"
