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

EXTRA_OECONF += "--with-python-includes=${STAGING_INCDIR}/../"

