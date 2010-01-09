require python-pygobject_${PV}.bb

DEPENDS = "python-native glib-2.0-native"

PARALLEL_MAKE = ""

inherit native

SRC_URI = "\
  ftp://ftp.gnome.org/pub/GNOME/sources/pygobject/${MAJ_VER}/pygobject-${PV}.tar.bz2 \
#  file://python-path.patch;patch=1 \
"

export GOBJECT_INTROSPECTION_CFLAGS="-pthread -I${STAGING_INCDIR}/gobject-introspection-1.0 -I${STAGING_INCDIR}/glib-2.0 -I${STAGING_LIBDIR}/glib-2.0/include"

do_stage_append() {
	install -d ${STAGING_BINDIR}
	install -m 0755 gobject/generate-constants ${STAGING_BINDIR}/gobject-generate-constants
}
