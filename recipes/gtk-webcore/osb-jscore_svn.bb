DESCRIPTION = "Gtk+ WebCore - JavaScriptCore"
HOMEPAGE = "http://gtk-webcore.sourceforge.net/"
LICENSE = "GPL"
PRIORITY = "optional"

PV = "0.5.2+svnr${SRCPV}"
PR = "r1"

SRC_URI = "svn://gtk-webcore.svn.sourceforge.net/svnroot/gtk-webcore/trunk;module=JavaScriptCore;proto=https \
           file://gcc4-fno-threadsafe-statics-JavaScriptCore.patch;patch=1"

S = "${WORKDIR}/JavaScriptCore"

inherit autotools pkgconfig

# zap CPPFLAGS to avoid trouble with internal vs. pcre from staging
CPPFLAGS = ""

do_configure () {
	autotools_do_configure
	cd ${S}

	# prevent libtool from linking libs against libstdc++, libgcc, ...
	cat ${TARGET_PREFIX}libtool | sed -e 's/postdeps=".*"/postdeps=""/' > ${TARGET_PREFIX}libtool.tmp
	mv ${TARGET_PREFIX}libtool.tmp ${TARGET_PREFIX}libtool
}

do_stage () {
	oe_libinstall -so -C kjs libgtk_webcore_jscore ${STAGING_LIBDIR}

	autotools_stage_includes

	install -d ${STAGING_INCDIR}/osb/JavaScriptCore
	for i in ${S}/kjs/*.h ${S}/kjs/new; do
		install -m 0644 $i ${STAGING_INCDIR}/osb/JavaScriptCore
	install -d ${STAGING_INCDIR}/../share/gtk-webcore-jscore
	install -m 0755 ${S}/kjs/create_hash_table  ${STAGING_INCDIR}/../share/gtk-webcore-jscore
	done
}
