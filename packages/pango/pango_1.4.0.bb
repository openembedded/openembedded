LICENSE = "LGPL"
SECTION = "x11/libs"
# Xt needed to keep autoconf's check for X11 happy
DEPENDS = "glib-2.0 fontconfig freetype zlib libx11 libxft libxt"
DESCRIPTION = "The goal of the Pango project is to provide an \
Open Source framework for the layout and rendering of \
internationalized text."

SRC_URI = "ftp://ftp.gtk.org/pub/gtk/v2.4/pango-${PV}.tar.bz2 \
	   file://gtk-doc.patch;patch=1 \
	   file://no-tests.patch;patch=1"

inherit autotools  pkgconfig

EXTRA_OECONF = "--disable-glibtest \
		--enable-explicit-deps=no \
	        --disable-debug"

FILES_${PN} = "/etc ${bindir} ${libdir}/libpango*.so.*"

LIBV = "1.4.0"

do_stage () {
	for lib in pango pangox pangoft2 pangoxft; do
		oe_libinstall -so -C pango lib$lib-1.0 ${STAGING_LIBDIR}/
	done
	install -d ${STAGING_INCDIR}/pango
	install -m 0644 ${S}/pango/pango*.h ${STAGING_INCDIR}/pango/
}

PACKAGES_DYNAMIC = "pango-module-*"

python populate_packages_prepend () {
	modules_root = bb.data.expand('${libdir}/pango/${LIBV}/modules', d)

	do_split_packages(d, modules_root, '^pango-(.*)\.so$', 'pango-module-%s', 'Pango module %s', 'pango-querymodules > /etc/pango/pango.modules')
}
