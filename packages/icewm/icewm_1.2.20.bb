SECTION = "x11/wm"
DESCRIPTION = "IceWM Window Manager"
LICENSE = "GPL"
DEPENDS = "libx11 libxext libxcomposite libxfixes libxdamage libxrender libxinerama libxpm xrandr xft"
PR = "r1" 

SRC_URI = "${SOURCEFORGE_MIRROR}/icewm/icewm-${PV}.tar.gz \
	   file://makefile.patch;patch=1"

S = "${WORKDIR}/icewm-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-i18n --without-imlib --with-xpm --with-gnome-menus"

pkg_postinst() {
update-alternatives --install /usr/bin/x-window-manager x-window-manager /usr/bin/icewm-session 10
}

pkg_postrm() {
update-alternatives --remove x-window-manager /usr/bin/icewm-session
}