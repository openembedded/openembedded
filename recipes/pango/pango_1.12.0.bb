LICENSE = "LGPL"
SECTION = "x11/libs"
DEPENDS = "glib-2.0 fontconfig freetype zlib virtual/libx11 libxft gtk-doc cairo"
DESCRIPTION = "The goal of the Pango project is to provide an \
Open Source framework for the layout and rendering of \
internationalized text."
PR = "r2"

RRECOMMENDS_${PN} = "pango-module-basic-x pango-module-basic-fc"

# seems to go wrong with default cflags
FULL_OPTIMIZATION_arm = "-O2"

SRC_URI = "http://download.gnome.org/sources/pango/1.12/pango-${PV}.tar.bz2 \
	   file://no-tests.patch;patch=1"

inherit autotools pkgconfig

DEFAULT_PREFERENCE="-1"

EXTRA_OECONF = "--disable-glibtest \
		--enable-explicit-deps=no \
	        --disable-debug"

LEAD_SONAME = "libpango-1.0*"
LIBV = "1.5.0"

FILES_${PN} = "/etc ${bindir}/* ${libdir}/libpango*.so.*"
FILES_${PN}-dbg += "${libdir}/pango/${LIBV}/modules/.debug"
FILES_${PN}-dev += "${libdir}/pango/${LIBV}/modules/*.la"

do_stage () {
	for lib in pango pangox pangoft2 pangoxft pangocairo; do
		oe_libinstall -so -C pango lib$lib-1.0 ${STAGING_LIBDIR}/
	done
	install -d ${STAGING_INCDIR}/pango
	install -m 0644 ${S}/pango/pango*.h ${STAGING_INCDIR}/pango/
}

postinst_prologue() {
if [ "x$D" != "x" ]; then
  exit 1
fi

}

PACKAGES_DYNAMIC = "pango-module-*"

python populate_packages_prepend () {
	prologue = bb.data.getVar("postinst_prologue", d, 1)

	modules_root = bb.data.expand('${libdir}/pango/${LIBV}/modules', d)

	do_split_packages(d, modules_root, '^pango-(.*)\.so$', 'pango-module-%s', 'Pango module %s', prologue + 'pango-querymodules > /etc/pango/pango.modules')
}

SRC_URI[md5sum] = "86c3e08169a18200e64a0c5ee1be7fd9"
SRC_URI[sha256sum] = "92cb2441d436e10dc811f4aeb85b7cc32210a1ea250b1c3f5ba7e9dc1e6924a2"
