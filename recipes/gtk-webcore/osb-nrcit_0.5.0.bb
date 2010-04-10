DESCRIPTION = "Gtk+ WebCore - NRCit embeddable browser component"
LICENSE = "nokia"
HOMEPAGE = "http://gtk-webcore.sourceforge.net/"
PRIORITY = "optional"
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

SRC_URI[md5sum] = "b02f4a0dcaac722ad7cdc112db964df4"
SRC_URI[sha256sum] = "8977c50529ecd51441897d675a3eca980d50e2b33fb0885f9dae1f3c9fd417c8"
