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

SRC_URI[md5sum] = "2d173b95ca5e64ef478c6a5d2deee9df"
SRC_URI[sha256sum] = "e394561d4426cf17e21eb5cc32e2972eb1af92d04a41808a41b1fb95320bd659"
