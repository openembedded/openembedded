require gtk+_${PV}.bb
inherit native
DEPENDS = "jpeg-native libpng-native gettext-native glib-2.0-native"
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
	cd gdk-pixbuf && oe_runmake install
}

do_install() {
	:
}

