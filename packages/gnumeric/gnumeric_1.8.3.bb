LICENSE = "GPL"
SECTION = "x11/utils"
S = "${WORKDIR}/gnumeric-${PV}"
DEPENDS = "libgsf gtk+ libxml2 goffice libglade libart-lgpl intltool-native libgnomecanvas libgnomeprint libgnomeprintui libbonoboui orbit2-native"
DESCRIPTION = "Gnumeric spreadsheet for GNOME"

PR = "r0"

PARALLEL_MAKE = ""

inherit gnome flow-lossage

SRC_URI += "file://remove-docs.patch;patch=1"

EXTRA_OECONF=" --without-perl "

PACKAGES_DYNAMIC += "gnumeric-plugin-*"

FILES_${PN}-dbg += "${libdir}/gnumeric/${PV}/plugins/*/.debug"
FILES_gnumeric_append = " /usr/lib/libspreadsheet-${PV}.so "

# We need native orbit-idl with target idl files. No way to say it in a clean way:
do_configure_append () {
	find -name Makefile -exec sed -i '/\/usr\/bin\/orbit-idl-2/{s:/usr/bin:${STAGING_BINDIR_NATIVE}:;s:/usr/share:${STAGING_DATADIR}:g}' {} \;
}

python populate_packages_prepend () {
	gnumeric_libdir = bb.data.expand('${libdir}/gnumeric/${PV}/plugins', d)

	do_split_packages(d, gnumeric_libdir, '(.*)', 'gnumeric-plugin-%s', 'Gnumeric plugin for %s', allow_dirs=True)
}
