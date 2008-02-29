DESCRIPTION = "Blackbox Window Manager"
SECTION = "x11/wm"
LICENSE = "GPL"
DEPENDS = "libx11 libxext libxcomposite libxfixes libxdamage libxrender libxinerama libxpm xrandr xft"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/blackboxwm/blackbox-0.70.1.tar.gz \
  file://remove-host-includes.patch;patch=1"
S = "${WORKDIR}/blackbox-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-i18n --without-imlib --with-xpm --with-gnome-menus"

