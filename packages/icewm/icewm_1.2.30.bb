DESCRIPTION = "IceWM Window Manager"
SECTION = "x11/wm"
LICENSE = "GPL"
DEPENDS = "virtual/libx11 libxext libxcomposite libxfixes libxdamage libxrender libxinerama libxpm xrandr xft mkfontdir-native"
RRECOMMENDS = "ttf-dejavu-sans"
PR = "r2"

SRC_URI = "\
  ${SOURCEFORGE_MIRROR}/icewm/icewm-${PV}.tar.gz \
  file://makefile.patch;patch=1 \
  file://configure.patch;patch=1 \
"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-i18n --without-imlib --with-xpm --with-gnome-menus \
	--x-includes=${STAGING_INCDIR} --x-libraries=${STAGING_LIBDIR} \
	--with-mkfontdir=${STAGING_BINDIR_NATIVE}/mkfontdir"

pkg_postinst() {
update-alternatives --install /usr/bin/x-window-manager x-window-manager /usr/bin/icewm-session 10
}

pkg_postrm() {
update-alternatives --remove x-window-manager /usr/bin/icewm-session
}
