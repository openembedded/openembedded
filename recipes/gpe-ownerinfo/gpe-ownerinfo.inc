inherit gpe

DESCRIPTION = "GPE owner information dialog"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+ libgpewidget"

do_compile_prepend() {
	sed -i -e 's: -s : :g' Makefile
}

do_install_append () {
	install -d ${D}${libdir}
	install -d ${D}${includedir}
	oe_libinstall -a libgpe-ownerinfo ${D}${libdir}
	install -m 0644 gpe-ownerinfo.h ${D}${includedir}
}

