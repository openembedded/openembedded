DESCRIPTION = "Fast-paced 2D top-down shooter where you have to destroy space station"
SECTION = "games"
PRIORITY = "optional"
LICENSE = "GPL"
AUTHOR = "David Olofson <david@olofson.net>"
HOMEPAGE = "http://olofson.net/kobodl"

PR = "r5"

DEPENDS = "libsdl-image virtual/libsdl"

RDEPENDS_${PN} = "${PN}-data"

SRC_URI = "http://olofson.net/kobodl/download/KoboDeluxe-${PV}.tar.bz2 \
           file://fighter-48.xpm \
					 file://debian-kobo.patch;patch=1 \
					 file://kobodeluxe-putenv.patch;patch=1 \
					 file://kobodeluxe-sysconf-support.patch;patch=1 \
					 file://kobodeluxe-menu-pointer.patch;patch=1 \
					 file://kobodeluxe-dimension-autoswap.patch;patch=1 \
           file://default-config \
          "

S = "${WORKDIR}/KoboDeluxe-${PV}"

inherit autotools sdl

APPIMAGE = "${WORKDIR}/fighter-48.xpm"
APPNAME = "kobodl"

EXTRA_OECONF = "--disable-opengl --disable-sdltest --enable-touchscreen"

export SDL_CONFIG = "${STAGING_BINDIR_CROSS}/sdl-config"

do_configure_prepend() {
  sed -i \
    -e "s|width WIDTH_HERE|width ${MACHINE_DISPLAY_WIDTH_PIXELS}|" \
    -e "s|height HEIGHT_HERE|height ${MACHINE_DISPLAY_HEIGHT_PIXELS}|" \
    ${WORKDIR}/default-config
}

do_install_append() {
  # Provide a default (working) configuration file
  install -d ${D}${sysconfdir}/kobo-deluxe
  install -m 755 ${WORKDIR}/default-config ${D}${sysconfdir}/kobo-deluxe
}

PACKAGES += "${PN}-data"

FILES_${PN} += "${sysconfdir}"
CONFFILES_${PN} = "${sysconfdir}/kobo-deluxe/default-config"

FILES_${PN}-data = "${datadir}"

PACKAGE_ARCH_${PN}-data = "all"
