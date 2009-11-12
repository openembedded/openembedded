DESCRIPTION = "Blackbox Window Manager"
SECTION = "x11/wm"
LICENSE = "GPL"
DEPENDS = "libx11 libxext libxcomposite libxfixes libxdamage libxrender libxinerama libxpm xrandr xft"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/blackboxwm/blackbox-0.70.1.tar.gz \
  file://remove-host-includes.patch;patch=1"
S = "${WORKDIR}/blackbox-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-i18n --without-imlib --with-xpm --with-gnome-menus"

#fix path of pc file
do_install_append() {
	sed -i s#${STAGING_LIBDIR}#${libdir}#g ${D}/${libdir}/pkgconfig/libbt.pc
}

do_stage () {
	sed -i s#${STAGING_LIBDIR}#${libdir}#g ${STAGING_LIBDIR}/pkgconfig/libbt.pc
}
