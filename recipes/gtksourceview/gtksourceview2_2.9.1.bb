DESCRIPTION = "Portable C library for multiline text editing"
HOMEPAGE = "http://projects.gnome.org/gtksourceview/"
LICENSE = "LGPL"
DEPENDS = "gtk+ libgnomeprint"

PNAME = "gtksourceview"

S = "${WORKDIR}/${PNAME}-${PV}"

inherit gnome lib_package

# overrule SRC_URI from gnome.conf
SRC_URI = "${GNOME_MIRROR}/${PNAME}/${@gnome_verdir("${PV}")}/${PNAME}-${PV}.tar.bz2"

SRC_URI += " \
           file://gtk-doc.make \
"

do_configure_prepend() {
    cp ${WORKDIR}/gtk-doc.make ${S}/
    sed -i -e s:docs::g ${S}/Makefile.am
    echo "EXTRA_DIST = version.xml" > gnome-doc-utils.make
}

FILES_${PN} += " ${datadir}/gtksourceview-2.0"

SRC_URI[md5sum] = "1e3a378af5f6319d53413394620c4e4a"
SRC_URI[sha256sum] = "b5ebdc5e7d33b99790c6dda14a717711963039f8ea6242c889f540b24ed6678f"
