DESCRIPTION = "libgdata is a GLib-based library for accessing online service APIs"
LICENSE = "LGPL"
DEPENDS = "libxml2 glib-2.0 libsoup-2.4"

inherit gnome lib_package autotools_stage

SRC_URI += " \
           file://gtk-doc.make \
"

do_configure_prepend() {
    cp ${WORKDIR}/gtk-doc.make ${S}/
    sed -i -e s:docs::g ${S}/Makefile.am
    echo "EXTRA_DIST = version.xml" > gnome-doc-utils.make
}




SRC_URI[archive.md5sum] = "06b14f1cd96432b0717ed03fe013ca4d"
SRC_URI[archive.sha256sum] = "55c616b0761faaa9fb028434de97b02d5145dfc52b1db632671ebc6cc6905575"
