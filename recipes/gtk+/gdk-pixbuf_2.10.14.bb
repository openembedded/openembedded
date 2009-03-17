DESCRIPTION = "Stand-alone libpixbuf, a pixelmap image i/o library from the \
GTK+ multi-platform toolkit for creating graphical user interfaces."
HOMEPAGE = "http://www.gtk.org/"
SECTION = "libs"
LICENSE = "LGPL"
PRIORITY = "optional"
DEPENDS = "libpng gettext glib-2.0"
PR = "r1"

S = "${WORKDIR}/gtk+-${PV}"
FILESPATH = "${FILE_DIRNAME}/gdk-pixbuf-csource:${FILE_DIRNAME}/gtk+-${PV}:${FILE_DIRNAME}/files"

SRC_URI = "ftp://ftp.gtk.org/pub/gtk/v2.10/gtk+-${PV}.tar.bz2 \
           file://automake-lossage.patch;patch=1 \
           file://reduce-dependencies.patch;patch=1"

#           file://no-xwc.patch;patch=1 \
#           file://disable-tooltips.patch;patch=1 \
#           file://gtklabel-resize-patch;patch=1 \
#           file://menu-deactivate.patch;patch=1 \
#           file://xsettings.patch;patch=1 \
#           file://scroll-timings.patch;patch=1 \
#           file://small-gtkfilesel.patch;patch=1 \
#           file://migration.patch;patch=1;pnum=0 \
#           file://run-iconcache.patch;patch=1 \
#           file://hardcoded_libtool.patch;patch=1 \
#           file://no-demos.patch;patch=1 \
#           file://single-click.patch;patch=1 \
#           file://spinbutton.patch;patch=1 \
#           file://gtk+-handhelds.patch;patch=1 \
#           file://filesel-fix-segfault.patch;patch=1 \
#           file://combo-arrow-size.patch;patch=1;pnum=0 \
#           file://range-no-redraw.patch;patch=1;pnum=0 \
#           file://scrolled-placement.patch;patch=1;pnum=0 \
#           file://treeview-checkbox-size.patch;patch=1;pnum=0 \
#           file://cell-renderer-edit-focus.patch;patch=1;pnum=0 \

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

