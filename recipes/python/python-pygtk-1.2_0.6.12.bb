DESCRIPTION = "Python Bindings for GTK+ 1.2"
HOMEPAGE = "http://www.gtk.org"
SECTION = "devel/python"
LICENSE = "LGPL"
DEPENDS = "gtk+-1.2"
RDEPENDS = "python-shell python-re"
SRCNAME = "pygtk"
PR = "r3"

SRC_URI = "ftp://ftp.gtk.org/pub/gtk/python/v1.2/${SRCNAME}-${PV}.tar.gz \
           file://remove-imlib-et-al.patch;patch=1 \
           file://acinclude.m4"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit autotools_stage pkgconfig distutils-base

EXTRA_OECONF += "--with-python-includes=${STAGING_INCDIR}/../"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/acinclude.m4 ${S}/
	echo ${LDFLAGS} > /tmp/ldflags
	rm -f aclocal.m4
}

FILES_${PN}-dev += "${datadir}/pygtk"

SRC_URI[md5sum] = "31f0991a18708d47fa29583c0ad956f6"
SRC_URI[sha256sum] = "7c95e6ae35d282fb333dc7b29bd91e543518ea7f3dfa11f21d52be0654234010"
