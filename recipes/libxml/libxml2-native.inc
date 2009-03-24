DESCRIPTION = "GNOME XML library"
DEPENDS = "python-native"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/libxml2-${PV}"

SRC_URI = "ftp://xmlsoft.org/libxml2/libxml2-${PV}.tar.gz"
S = "${WORKDIR}/libxml2-${PV}"

inherit distutils-base autotools native pkgconfig

do_configure_prepend () {
	EXTRA_OECONF = "\
	--with-python=${PYTHON_DIR} \
	--without-debug \
	--without-legacy \
	--with-catalog \
	--without-docbook \
	--with-c14n \
	"
}

do_stage () {
	oe_runmake install
}
