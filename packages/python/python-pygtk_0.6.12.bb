DESCRIPTION = "Python GTK+ 1.2 Bindings"
HOMEPAGE = "http://www.gtk.org"
SECTION = "devel/python"
LICENSE = "LGPL"
MAINTAINER = "Rob Taylor <robtaylor@fastmail.fm>"
DEPENDS = "gtk+-1.2"
RDEPENDS = "python-shell python-re"
SRCNAME = "pygtk"
PR = "r0"

SRC_URI = "ftp://ftp.gtk.org/pub/gtk/python/v1.2/${SRCNAME}-${PV}.tar.gz \
           file://remove-imlib-et-al;patch=1"
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
