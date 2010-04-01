DESCRIPTION = "icon theme for matchbox-panel-2"
LICENSE = "GPLv2"
SECTION = "x11/panels"
DEPENDS = "imagemagick-native"
RPROVIDES_${PN} = "matchbox-panel-2-icon-theme"
PACKAGE_ARCH = "all"
SRCREV_FORMAT = "startup"
SRCREV = "1907"
PV = "0.0.1+svnr${SRCPV}"
PR = "r0"

inherit gtk-icon-cache

SRC_URI = "svn://svn.o-hand.com/repos/matchbox/trunk;module=matchbox-panel-2/applets/battery/data;proto=http;maxrev=1918 \
	   svn://svn.o-hand.com/repos/matchbox/trunk;module=matchbox-panel-2/applets/startup/data;proto=http;name=startup \
	   svn://svn.o-hand.com/repos/matchbox/trunk;module=matchbox-panel-2/applets/brightness/data;proto=http \
	   file://user-desktop.png \
	   file://task-switcher.png \
"
S = "${WORKDIR}"

do_install() {
	cd ${S}
	mkdir -p ${D}${datadir}/icons/HighContrast/48x48/status ${D}${datadir}/icons/HighContrastInverse/48x48/status
	install -m 0644 matchbox-panel-2/applets/battery/data/*.png ${D}${datadir}/icons/HighContrastInverse/48x48/status/
	mkdir -p ${D}${datadir}/icons/HighContrast/32x32/status ${D}${datadir}/icons/HighContrastInverse/32x32/status
	install -m 0644 matchbox-panel-2/applets/brightness/data/*.png ${D}${datadir}/icons/HighContrastInverse/32x32/status/
	mkdir -p ${D}${datadir}/icons/HighContrast/32x32/animations ${D}${datadir}/icons/HighContrastInverse/32x32/animations
	install -m 0644 matchbox-panel-2/applets/startup/data/*.png ${D}${datadir}/icons/HighContrastInverse/32x32/animations/
	cd ${D}${datadir}/icons/HighContrastInverse
	for PNG in */*/*.png ; do
		convert -negate $PNG ../HighContrast/$PNG
	done
	cd ${S}
	mkdir -p ${D}${datadir}/icons/HighContrast/32x32/apps ${D}${datadir}/icons/HighContrastInverse/32x32/apps
	install -m 0644 user-desktop.png task-switcher.png ${D}${datadir}/icons/HighContrast/32x32/apps/
	cd ${D}${datadir}/icons/HighContrast
	for PNG in 32x32/apps/*.png ; do
		convert -negate $PNG ../HighContrastInverse/$PNG
	done
	cd ${S}

	# FIXME: The default vendor provided theme uses "white on
	# transparent" style and it is invisible with the default GTK+
	# style. We need a better solution for fallback icons and dark
	# themes. For now, define only "black on transparent" as
	# hicolor. It is still pretty ugly: Hicolor is expected to be
	# hicolor, makes icons invisible in dark themes.
	rm -r ${D}${datadir}/icons/HighContrastInverse
	mv ${D}${datadir}/icons/HighContrast ${D}${datadir}/icons/hicolor
}

FILES_${PN} += "${datadir}/icons/*"
