DESCRIPTION = "GNOME XML library"
DEPENDS = "python-native"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/libxml2-${PV}"

SRC_URI = "ftp://xmlsoft.org/libxml2/libxml2-${PV}.tar.gz"
S = "${WORKDIR}/libxml2-${PV}"

inherit autotools native pkgconfig distutils-native-base

do_configure_prepend () {
	EXTRA_LIBXML2_OECONF="\
	--with-python=${PYTHON_DIR} \
	--without-debug \
	--without-legacy \
	--with-catalog \
	--without-docbook \
	--with-c14n \
	"
}

do_configure (){
	autotools_do_configure ${EXTRA_LIBXML2_OECONF}
}

do_install_append() {
	:
}
