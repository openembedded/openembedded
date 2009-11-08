DESCRIPTION = "GNOME utilities"
SECTION = "x11/gnome"
LICENSE = "GPL"
DEPENDS = "nautilus gnome-common glib-2.0 gtk+ gconf liboobs system-tools-backends gnome-control-center"
inherit gnome pkgconfig

PR = "r1"

EXTRA_OECONF = "--disable-scrollkeeper \
               "
LDFLAGS += "-lgthread-2.0"

do_configure_prepend () {
	for i in $(find . -name "Makefile.in") ; do
		sed -i -e 's:MKINSTALLDIRS = @MKINSTALLDIRS@:MKINSTALLDIRS = @mkdir_p@:g' $i
	done
}

do_install_append () {
	rm ${D}/${datadir}/gnome/help/services-admin/C/figures/service-properties.png
	rm ${D}/${datadir}/gnome/help/services-admin/ca/figures/service-properties.png
	rm ${D}/${datadir}/gnome/help/services-admin/de/figures/service-properties.png
	rm ${D}/${datadir}/gnome/help/services-admin/el/figures/service-properties.png
	rm ${D}/${datadir}/gnome/help/services-admin/en_GB/figures/service-properties.png
	rm ${D}/${datadir}/gnome/help/services-admin/es/figures/service-properties.png
	rm ${D}/${datadir}/gnome/help/services-admin/fr/figures/service-properties.png
	rm ${D}/${datadir}/gnome/help/services-admin/it/figures/service-properties.png
	rm ${D}/${datadir}/gnome/help/services-admin/nl/figures/service-properties.png
	rm ${D}/${datadir}/gnome/help/services-admin/oc/figures/service-properties.png
	rm ${D}/${datadir}/gnome/help/services-admin/sv/figures/service-properties.png
}

FILES_${PN} += "${libdir}/nautilus/extensions-2.0"

FILES_${PN}-dbg += "${libdir}/nautilus/extensions-2.0/.debug"

