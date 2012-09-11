DESCRIPTION = "Stand-alone libpixbuf, a pixelmap image i/o library from the \
GTK+ multi-platform toolkit for creating graphical user interfaces."
HOMEPAGE = "http://www.gtk.org/"
SECTION = "libs"
LICENSE = "LGPL"
PRIORITY = "optional"
DEPENDS = "libpng gettext glib-2.0 atk pango cairo"
PR = "r2"

S = "${WORKDIR}/gtk+-${PV}"
FILESPATHPKG =. "gdk-pixbuf-csource:gtk+-${PV}:"

SRC_URI = "\
  ftp://ftp.gtk.org/pub/gtk/v2.10/gtk+-${PV}.tar.bz2 \
  file://automake-lossage.patch \
"

inherit autotools pkgconfig

LIBV = "2.10.0"

FILES_${PN} = "${bindir}/gdk-pixbuf-query-loaders \
	${bindir}/gtk-update-icon-cache \
	${libdir}/lib*.so.*"

FILES_${PN}-dev += " \
    ${datadir}/gtk-2.0/include \
	${libdir}/gtk-2.0/include \
	${libdir}/gtk-2.0/${LIBV}/loaders/*.la \
	${bindir}/gdk-pixbuf-csource \
	${bindir}/gtk-builder-convert"

FILES_${PN}-dbg += " \
        ${libdir}/gtk-2.0/${LIBV}/loaders/.debug/*"

EXTRA_OECONF = "\
  --without-x \
  --with-gdktarget=linux-fb \
  --without-libtiff \
  --without-libjpeg \
  --with-libpng \
"

EXTRA_OECONF += "--disable-modules --with-included-loaders=png,tga"

# check for TARGET_FPU=soft and inform configure of the result so it can disable some floating points
require gtk-fpu.inc
EXTRA_OECONF += "${@get_gtk_fpu_setting(bb, d)}"

do_compile() {
	cd gdk-pixbuf && oe_runmake
}

do_stage() {
	oe_libinstall -C gdk-pixbuf -so libgdk_pixbuf-2.0 ${STAGING_LIBDIR}
	cd gdk-pixbuf && oe_runmake install DESTDIR=${STAGING_DIR_HOST}${layout_exec_prefix}
	autotools_stage_includes
#	install -d -m 0755 ${STAGING_LIBDIR}/gtk-2.0/include
#	install -m 0644 gdk/gdkconfig.h ${STAGING_LIBDIR}/gtk-2.0/include/gdkconfig.h
}

do_install() {
	oe_libinstall -C gdk-pixbuf -so libgdk_pixbuf-2.0 ${D}/${libdir}
	cd gdk-pixbuf && oe_runmake install DESTDIR=${D}
}

BBCLASSEXTEND = "native"

SRC_URI[md5sum] = "018d7dd0fa7de01cfdb77c7c55e7ba26"
SRC_URI[sha256sum] = "d02344239d048390ba02fcfd7de4f9efc0dfb51e7b06dfa46a6314d666ea4de2"
