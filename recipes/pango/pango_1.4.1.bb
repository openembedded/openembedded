LICENSE = "LGPL"
SECTION = "x11/libs"
DEPENDS = "glib-2.0 fontconfig freetype zlib virtual/libx11 libxft gtk-doc"
DESCRIPTION = "The goal of the Pango project is to provide an \
Open Source framework for the layout and rendering of \
internationalized text."

SRC_URI = "ftp://ftp.gtk.org/pub/gtk/v2.4/pango-${PV}.tar.bz2 \
	   file://no-tests.patch;patch=1"

inherit autotools pkgconfig

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

SRC_URI[md5sum] = "39868e0da250fd4c00b2970e4eb84389"
SRC_URI[sha256sum] = "4f35ba6d3537c9386d6262bfe601a418bf34fe0be3bb0139ec2d3bd9435d4d3f"
