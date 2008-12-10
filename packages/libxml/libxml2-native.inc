DESCRIPTION = "GNOME XML library"
DEPENDS = "python-native"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/libxml2-${PV}"
PR = "r3"

SRC_URI = "ftp://xmlsoft.org/libxml2/libxml2-${PV}.tar.gz"
S = "${WORKDIR}/libxml2-${PV}"

inherit distutils-base autotools native pkgconfig

EXTRA_OECONF = "\
  --with-python=${STAGING_INCDIR}/${PYTHON_MAJMIN} \
  --without-debug \
  --without-legacy \
  --without-catalog \
  --without-docbook \
  --with-c14n \
"

do_stage () {
	oe_runmake install
}
