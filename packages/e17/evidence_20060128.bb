DESCRIPTION = "evidence, an enlightenemt file manager"
LICENSE = "GPL"
# can support dbus, avifile, libmpeg3
DEPENDS = "pkgconfig gtk+ glib-2.0 ecore-x11 evas-x11 edb eet edje imlib2-x11 libpng epeg jpeg pcre curl taglib libvorbis libogg libxine-x11 emotion freetype"
RDEPENDS += "examine"
PR = "r0"

inherit e

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/evidence;module=evidence;date=${PV}"
S = "${WORKDIR}/evidence"

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR}/edje_cc \
	--enable-ecore \
	--enable-ecore-ipc \
	--enable-canvas-evas2 \
	--enable-edje \
	--enable-x \
	--enable-tree-view \
	--enable-icon-view \
	--enable-browser-view \
	--with-libxine=${STAGING_LIBDIR}"

do_compile_prepend() {
	sed -i 's:LDFLAGS = :LDFLAGS = -L${STAGING_LIBDIR} :' ${S}/src/providers/vorbis/Makefile
}

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir} /etc/* /usr/sbin/*"

