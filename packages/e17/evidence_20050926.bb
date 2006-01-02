DESCRIPTION = "evidence, an enlightenemt file manager"
LICENSE = "GPL"
SECTION = "e"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
# can support dbus, avifile, libmpeg3
DEPENDS = "pkgconfig gtk+ glib-2.0 ecore-x11 evas-x11 edb eet edje imlib2-x11 libpng epeg jpeg pcre curl taglib libvorbis libogg libxine-x11 emotion freetype"
RDEPENDS += "examine"
PR = "r0"
CVSDATE = "${PV}"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/evidence;module=evidence"
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

do_prepsources () {
  make clean distclean || true
}
addtask prepsources after do_fetch before do_unpack

do_compile_prepend() {
	sed -i 's:LDFLAGS = :LDFLAGS = -L${STAGING_LIBDIR} :' ${S}/src/providers/vorbis/Makefile
}

export EET_CONFIG = "${STAGING_BINDIR}/eet-config"
export EVAS_CONFIG = "${STAGING_BINDIR}/evas-config"
export ECORE_CONFIG = "${STAGING_BINDIR}/ecore-config"
export EMBRYO_CONFIG = "${STAGING_BINDIR}/embryo-config"
export EDJE_CONFIG = "${STAGING_BINDIR}/edje-config"

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir} /etc/* /usr/sbin/*"

inherit autotools pkgconfig binconfig
