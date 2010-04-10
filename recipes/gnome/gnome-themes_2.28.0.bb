DESCRIPTION = "GNOME themes"
LICENSE = "GPL"
SECTION = "x11/gnome"
DEPENDS = "gtk-engines icon-naming-utils-native glib-2.0 intltool-native"
RDEPENDS = "gnome-icon-theme"

EXTRA_OECONF = "--enable-all-themes --disable-hicolor-check"

inherit gnome

PACKAGE_ARCH = "all"

PACKAGES =+ " gnome-theme-crux gnome-theme-highcontrast gnome-theme-highcontrastinverse gnome-theme-highcontrastlargeprint gnome-theme-highcontrastlargeprintinverse gnome-theme-largeprint gnome-theme-mist"
FILES_gnome-theme-crux = "${datadir}/themes/Crux ${datadir}/icons/Crux"
FILES_gnome-theme-highcontrast = "${datadir}/themes/HighContrast ${datadir}/icons/HighContrast"
FILES_gnome-theme-highcontrastinverse = "${datadir}/themes/HighContrastInverse ${datadir}/icons/HighContrastInverse"
FILES_gnome-theme-highcontrastlargeprint = "${datadir}/themes/HighContrastLargePrint ${datadir}/icons/HighContrastLargePrint"
FILES_gnome-theme-highcontrastlargeprintinverse = "${datadir}/themes/HighContrastLargePrintInverse ${datadir}/icons/HighContrastLargePrintInverse"
FILES_gnome-theme-largeprint = "${datadir}/themes/LargePrint ${datadir}/icons/LargePrint"
FILES_gnome-theme-mist = "${datadir}/themes/Mist ${datadir}/icons/Mist"

FILES_${PN} += "${datadir}/themes ${datadir}/icons"

SRC_URI[archive.md5sum] = "c89c3e08e45c4e94d76a9a7d40b74214"
SRC_URI[archive.sha256sum] = "46e8a91464843ab21cade3c470494f3f831932e2b72ca36d484f4fd6efd75a47"
