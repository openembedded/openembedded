require gtk+_${PV}.bb
inherit native
DEPENDS = "jpeg-native libpng-native gettext-native glib-2.0-native libx11-native"
S = "${WORKDIR}/gtk+-${PV}"
FILESPATHPKG =. "gdk-pixbuf-csource:gtk+-${PV}:"
SRC_URI += "file://reduce-dependencies.patch"

#clear recommends for uclibc builds
RRECOMMENDS_${PN} = " "
RRECOMMENDS_${PN}_linux = "  "
RRECOMMENDS_${PN}_linux-gnueabi = " "

EXTRA_OECONF = "\
  --with-gdktarget=x11 \
  --without-libtiff \
  --with-libjpeg \
  --with-libpng \
  --disable-cups \
"

do_compile() {
	cd gdk-pixbuf && oe_runmake
}

do_stage() {
	cd gdk-pixbuf && oe_runmake install
	find ${libdir} -name "libpixbufloader-*.la" -exec rm \{\} \;
}

do_install() {
	:
}

