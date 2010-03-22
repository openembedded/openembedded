require python-pygobject_${PV}.bb

inherit native

DEPENDS = "python-native glib-2.0-native"

PARALLEL_MAKE = ""

SRC_URI = "\
  ftp://ftp.gnome.org/pub/GNOME/sources/pygobject/${MAJ_VER}/pygobject-${PV}.tar.bz2 \
#  file://python-path.patch;patch=1 \
"

export GOBJECT_INTROSPECTION_CFLAGS="-pthread -I${STAGING_INCDIR}/gobject-introspection-1.0 -I${STAGING_INCDIR}/glib-2.0 -I${STAGING_LIBDIR}/glib-2.0/include"

do_configure_prepend() {
	unset PYTHONPATH
}

do_install_append() {
	install -d ${D}${bindir}
	install -m 0755 gobject/generate-constants ${D}${bindir}/gobject-generate-constants
}
