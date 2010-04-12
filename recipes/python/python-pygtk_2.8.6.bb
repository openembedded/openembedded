DESCRIPTION = "Python GTK+ Bindings"
SECTION = "devel/python"
PRIORITY = "optional"
# needs gtk+ 2.8.x
DEPENDS = "gtk+-2.8.16 libglade"
RDEPENDS = "python-shell"
SRCNAME = "pygtk"
LICENSE = "LGPL"
PR = "r2"

MAJ_VER = "${@bb.data.getVar('PV',d,1).split('.')[0]}.${@bb.data.getVar('PV',d,1).split('.')[1]}"
SRC_URI = "ftp://ftp.gnome.org/pub/gnome/sources/pygtk/${MAJ_VER}/${SRCNAME}-${PV}.tar.bz2 \
           file://acinclude.m4"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit autotools pkgconfig distutils-base

EXTRA_OECONF += "--with-python-includes=${STAGING_INCDIR}/../"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/acinclude.m4 ${S}/
}

do_stage() {
	autotools_stage_includes
	install -m 0755 codegen/pygtk-codegen-2.0 ${STAGING_BINDIR_NATIVE}/
}

SRC_URI[md5sum] = "c69c2e5e86a8f21a5773df20e265fc3a"
SRC_URI[sha256sum] = "dee1ec46a43bf624f1ff796903bd2d49e65c1cc8396385f46bf1489817bd6e60"
