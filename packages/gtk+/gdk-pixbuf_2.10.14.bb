DESCRIPTION = "GDK PixBuf is a pixelmap image support library from the GTK+ \
multi-platform toolkit for creating graphical user interfaces."
HOMEPAGE = "http://www.gtk.org/"
SECTION = "libs"
LICENSE = "LGPL"
PRIORITY = "optional"
DEPENDS = "jpeg libpng gettext glib-2.0"

S = "${WORKDIR}/gtk+-${PV}"
FILESPATH = "${FILE_DIRNAME}/gdk-pixbuf-csource:${FILE_DIRNAME}/gtk+-${PV}:${FILE_DIRNAME}/files"
PR = "r0"

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

# check for TARGET_FPU=soft and inform configure of the result so it can disable some floating points
require gtk-fpu.inc
EXTRA_OECONF += "${@get_gtk_fpu_setting(bb, d)}"

inherit autotools pkgconfig

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
  --with-libjpeg \
  --with-libpng \
"

LIBV = "2.10.0"

do_compile() {
	cd gdk-pixbuf && oe_runmake
}

do_stage() {
	oe_libinstall -C gdk-pixbuf -so libgdk_pixbuf-2.0 ${STAGING_LIBDIR}
	cd gdk-pixbuf && oe_runmake install DESTDIR=${STAGING_DIR}/usr
	autotools_stage_includes
#	install -d -m 0755 ${STAGING_LIBDIR}/gtk-2.0/include
#	install -m 0644 gdk/gdkconfig.h ${STAGING_LIBDIR}/gtk-2.0/include/gdkconfig.h
}

do_install() {
	oe_libinstall -C gdk-pixbuf -so libgdk_pixbuf-2.0 ${D}/${libdir}
	cd gdk-pixbuf && oe_runmake install DESTDIR=${D}
}

postinst_prologue() {
if [ "x$D" != "x" ]; then
  exit 1
fi
}

PACKAGES_DYNAMIC = "gdk-pixbuf-loader-*"

python populate_packages_prepend () {
	import os.path

	prologue = bb.data.getVar("postinst_prologue", d, 1)

	gtk_libdir = bb.data.expand('${libdir}/gtk-2.0/${LIBV}', d)
	loaders_root = os.path.join(gtk_libdir, 'loaders')
	do_split_packages(d, loaders_root, '^libpixbufloader-(.*)\.so$', 'gdk-pixbuf-loader-%s', 'GDK pixbuf loader for %s', prologue + 'gdk-pixbuf-query-loaders > /etc/gtk-2.0/gdk-pixbuf.loaders')
        if (bb.data.getVar('DEBIAN_NAMES', d, 1)):
                bb.data.setVar('PKG_${PN}', 'libgtk-2.0', d)
}
