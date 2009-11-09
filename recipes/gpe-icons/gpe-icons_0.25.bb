DESCRIPTION = "Common icons for GPE"
LICENSE = "GPL"
SECTION = "gpe"

RDEPENDS = "gdk-pixbuf-loader-png"


inherit gpe

PR = "r2"

#only icons present in the package
PACKAGE_ARCH = "all"
FILES_${PN} = "${datadir}/gpe"

do_configure_prepend() {
        sed -i "s| \$(DESTDIR)\$(PREFIX)/share/gpe/pixmaps/| \$(DESTDIR)\$(PREFIX)/share/gpe/pixmaps.${PN}/|g" Makefile
}

require gpe-icons.inc
