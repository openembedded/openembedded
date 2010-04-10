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




SRC_URI[archive.md5sum] = "fc9be11d2f823bb16d6e03e2a0dda85d"
SRC_URI[archive.sha256sum] = "2b90f206063405ae6cf579ed3a090b0130e849e1ead02b2ad2ed4fc6d7f585a0"
