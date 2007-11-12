require gtk+_${PV}.bb
DEPENDS = "jpeg libpng gettext glib-2.0"
S = "${WORKDIR}/gtk+-${PV}"
FILESPATH = "${FILE_DIRNAME}/gdk-pixbuf-csource:${FILE_DIRNAME}/gtk+-${PV}:${FILE_DIRNAME}/files"
SRC_URI += "file://reduce-dependencies.patch;patch=1"

#clear recommends for uclibc builds
RRECOMMENDS = " "
RRECOMMENDS_${PN}_linux = "  "
RRECOMMENDS_${PN}_linux-gnueabi = " "

EXTRA_OECONF = "\
  --without-x \
  --with-gdktarget=linux-fb \
  --without-libtiff \
  --with-libjpeg \
  --with-libpng \
"

do_compile() {
	cd gdk-pixbuf && oe_runmake
}

do_stage() {
#	oe_libinstall -so -C gdk-pixbuf libgdk_pixbuf-2.0 ${STAGING_LIBDIR}
	cd gdk-pixbuf && oe_runmake install DESTDIR=${STAGING_DIR}/usr
	autotools_stage_includes
#	install -d -m 0755 ${STAGING_LIBDIR}/gtk-2.0/include
#	install -m 0644 gdk/gdkconfig.h ${STAGING_LIBDIR}/gtk-2.0/include/gdkconfig.h
}

do_install() {
	cd gdk-pixbuf
}

# override the function in gtk-*.inc (included by gtk+*.bb)
populate_packages_prepend () {

}
