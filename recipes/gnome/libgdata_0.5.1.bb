DESCRIPTION = "libgdata is a GLib-based library for accessing online service APIs"
LICENSE = "LGPL"
DEPENDS = "libxml2 glib-2.0 libsoup-2.4"

inherit gnome lib_package autotools_stage

SRC_URI += " \
           file://gtk-doc.make \
"

PARALLEL_MAKE = ""

do_configure_prepend() {
    cp ${WORKDIR}/gtk-doc.make ${S}/
    sed -i -e s:docs::g ${S}/Makefile.am
    echo "EXTRA_DIST = version.xml" > gnome-doc-utils.make
}



