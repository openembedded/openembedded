SECTION = "x11/base"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
LICENSE = "LGPL"
DESCRIPTION = "GNOME themes"

DEPENDS = "gtk-engines intltool-native"

PACKAGES += " gtk-engine-crux gtk-engine-hc gtk-engine-lighthouseblue gtk-engine-mist gtk-engine-thinice"
FILES_gtk-engine-crux = "${libdir}/gtk-2.0/*/engines/libcrux-engine.so"
FILES_gtk-engine-hc = "${libdir}/gtk-2.0/*/engines/libhcengine.so"
FILES_gtk-engine-lighthouseblue = "${libdir}/gtk-2.0/*/engines/liblighthouseblue.so"
FILES_gtk-engine-mist = "${libdir}/gtk-2.0/*/engines/libmist.so"
FILES_gtk-engine-thinice = "${libdir}/gtk-2.0/*/engines/libthinice.so"

PACKAGES += " gnome-theme-crux gnome-theme-grand-canyon gnome-theme-highcontrast gnome-theme-highcontrastinverse gnome-theme-highcontrastlargeprint gnome-theme-highcontrastlargeprintinverse gnome-theme-largeprint gnome-theme-lighthouseblue gnome-theme-mist gnome-theme-traditional"
FILES_gnome-theme-crux = "${datadir}/themes/Crux"
FILES_gnome-theme-grand-canyon = "${datadir}/themes/Grand-Canyon"
FILES_gnome-theme-highcontrast = "${datadir}/themes/HighContrast"
FILES_gnome-theme-highcontrastinverse = "${datadir}/themes/HighContrastInverse"
FILES_gnome-theme-highcontrastlargeprint = "${datadir}/themes/HighContrastLargePrint"
FILES_gnome-theme-highcontrastlargeprintinverse = "${datadir}/themes/HighContrastLargePrintInverse"
FILES_gnome-theme-largeprint = "${datadir}/themes/LargePrint"
FILES_gnome-theme-lighthouseblue = "${datadir}/themes/LighthouseBlue"
FILES_gnome-theme-mist = "${datadir}/themes/Mist"
FILES_gnome-theme-traditional = "${datadir}/themes/Traditional"

SRC_URI = "${GNOME_MIRROR}/${PN}/2.6/${PN}-${PV}.tar.bz2"

# gcc-3.4 blows up in gtktext with -frename-registers on arm-linux
CFLAGS := "${@'${CFLAGS}'.replace('-frename-registers', '')}"

inherit autotools
