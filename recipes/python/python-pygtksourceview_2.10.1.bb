DESCRIPTION = "Python gtksourceview Bindings"
SECTION = "devel/python"
HOMEPAGE = "http://projects.gnome.org/gtksourceview/pygtksourceview.html"
PRIORITY = "optional"
DEPENDS = "gtksourceview2 python-pygtk"
SRCNAME = "pygtksourceview"
LICENSE = "LGPL"
PR = "r0"

MAJ_VER = "${@bb.data.getVar('PV',d,1).split('.')[0]}.${@bb.data.getVar('PV',d,1).split('.')[1]}"
SRC_URI = "ftp://ftp.gnome.org/pub/gnome/sources/pygtksourceview/${MAJ_VER}/${SRCNAME}-${PV}.tar.bz2"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit autotools pkgconfig distutils-base

do_configure_prepend() {
	sed -i \
		-e s:'`$PKG_CONFIG --variable=codegendir pygtk-2.0`':\"${STAGING_DATADIR}/pygobject/2.0/codegen\":g \
		${S}/configure.ac
}

FILES_${PN} += "${datadir}/pygtk/2.0/defs/gtksourceview2.defs"

SRC_URI[md5sum] = "2654354d61422fb79d8375fc3a3b5393"
SRC_URI[sha256sum] = "b4b47c5aeb67a26141cb03663091dfdf5c15c8a8aae4d69c46a6a943ca4c5974"
