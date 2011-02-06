require python-pygobject_${PV}.bb

inherit native

DEPENDS = "python-native glib-2.0-native"
RDEPENDS_${PN} = ""

PARALLEL_MAKE = ""

SRC_URI = "\
  ftp://ftp.gnome.org/pub/GNOME/sources/pygobject/${MAJ_VER}/pygobject-${PV}.tar.bz2 \
#  file://python-path.patch \
"

export GOBJECT_INTROSPECTION_CFLAGS="-pthread -I${STAGING_INCDIR}/gobject-introspection-1.0 -I${STAGING_INCDIR}/glib-2.0 -I${STAGING_LIBDIR}/glib-2.0/include"

do_configure_prepend() {
	unset PYTHONPATH
}

do_install_append() {
	install -d ${D}${bindir}
	install -m 0755 gobject/generate-constants ${D}${bindir}/gobject-generate-constants
}

SRC_URI[md5sum] = "10e1fb79be3d698476a28b1e1b0c5640"
SRC_URI[sha256sum] = "41e923a3f4426a3e19f6d154c424e3dac6f39defca77af602ac6272ce270fa81"
