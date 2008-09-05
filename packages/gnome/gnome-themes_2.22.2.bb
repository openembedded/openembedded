LICENSE = "GPL"
SECTION = "x11/gnome"
DEPENDS = "gtk-engines icon-naming-utils-native glib-2.0 intltool-native"
RDEPENDS = "gnome-icon-theme"

EXTRA_OECONF = "--enable-all-themes --disable-hicolor-check"

inherit gnome

PACKAGE_ARCH = "all"

PACKAGES =+ " gtk-engine-crux gtk-engine-hc gtk-engine-lighthouseblue gtk-engine-mist gtk-engine-thinice"
FILES_gtk-engine-crux = "${libdir}/gtk-2.0/*/engines/libcrux-engine.so"
FILES_gtk-engine-hc = "${libdir}/gtk-2.0/*/engines/libhcengine.so"
FILES_gtk-engine-lighthouseblue = "${libdir}/gtk-2.0/*/engines/liblighthouseblue.so"
FILES_gtk-engine-mist = "${libdir}/gtk-2.0/*/engines/libmist.so"
FILES_gtk-engine-thinice = "${libdir}/gtk-2.0/*/engines/libthinice.so"

PACKAGES =+ " gnome-theme-crux gnome-theme-grand-canyon gnome-theme-highcontrast gnome-theme-highcontrastinverse gnome-theme-highcontrastlargeprint gnome-theme-highcontrastlargeprintinverse gnome-theme-largeprint gnome-theme-lighthouseblue gnome-theme-mist gnome-theme-traditional"
FILES_gnome-theme-crux = "${datadir}/themes/Crux ${datadir}/icons/Crux"
FILES_gnome-theme-grand-canyon = "${datadir}/themes/Grand-Canyon ${datadir}/icons/Grand-Canyon"
FILES_gnome-theme-highcontrast = "${datadir}/themes/HighContrast ${datadir}/icons/HighContrast"
FILES_gnome-theme-highcontrastinverse = "${datadir}/themes/HighContrastInverse ${datadir}/icons/HighContrastInverse"
FILES_gnome-theme-highcontrastlargeprint = "${datadir}/themes/HighContrastLargePrint ${datadir}/icons/HighContrastLargePrint"
FILES_gnome-theme-highcontrastlargeprintinverse = "${datadir}/themes/HighContrastLargePrintInverse ${datadir}/icons/HighContrastLargePrintInverse"
FILES_gnome-theme-largeprint = "${datadir}/themes/LargePrint ${datadir}/icons/LargePrint"
FILES_gnome-theme-lighthouseblue = "${datadir}/themes/LighthouseBlue ${datadir}/icons/LighthouseBlue"
FILES_gnome-theme-mist = "${datadir}/themes/Mist ${datadir}/icons/Mist"
FILES_gnome-theme-traditional = "${datadir}/themes/Traditional ${datadir}/icons/Traditional"

FILES_${PN} += "${datadir}/themes ${datadir}/icons"
