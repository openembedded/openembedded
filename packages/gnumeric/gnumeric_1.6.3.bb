LICENSE = "GPL"
SECTION = "x11/utils"
S = "${WORKDIR}/gnumeric-${PV}"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"
DEPENDS = "libgsf gtk+ libxml2 goffice libglade libart-lgpl intltool-native libgnomecanvas libgnomeprint libgnomeprintui libbonoboui"
DESCRIPTION = "Gnumeric spreadsheet for GNOME"

inherit gnome flow-lossage

SRC_URI += "file://remove-docs.patch;patch=1"

EXTRA_OECONF=" --without-perl "

PACKAGES_DYNAMIC = "gnumeric-plugin-*"

FILES_gnumeric_append = " /usr/lib/libspreadsheet-${PV}.so "

python populate_packages_prepend () {
	gnumeric_libdir = bb.data.expand('${libdir}/gnumeric/${PV}/plugins', d)

	do_split_packages(d, gnumeric_libdir, '(.*)', 'gnumeric-plugin-%s', 'Gnumeric plugin for %s', allow_dirs=True)
}
