DESCRIPTION = "Python GTK+ 1.2 Bindings"
SECTION = "devel/python"
SRCNAME = "pygobject"
PR = "r0"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/pygobject/2.12/pygobject-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit autotools pkgconfig distutils-base

FILES_${PN} = "${libdir}/${PYTHON_DIR}/"

do_configure_prepend() {
	echo ${LDFLAGS} > /tmp/ldflags
	rm -f aclocal.m4
}

do_stage() {
	autotools_stage_includes
}
