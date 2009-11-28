DESCRIPTION = "Open source clone of the Microprose game 'Transport Tycoon Deluxe' - SDL edition."
HOMEPAGE = "http://www.openttd.org"
LICENSE = "GPLv2"
DEPENDS = "libsdl-net libpng zlib freetype fontconfig"
RRECOMMENDS = "openttd-gfx openttd-sfx"

inherit siteinfo sdl

SRC_URI ="http://binaries.openttd.org/releases/${PV}/${P}-source.tar.bz2 "
SRC_URI_append_shr = " file://openttd.cfg"

APPIMAGE = "media/openttd.128.png"

do_configure() {
  # The way the OTTD configure system handles the application's directories
  # isn't the way autotools does it. Mainly prefix is always prepended even if
  # absolute binary-dir and data-dir is given. 

  ${S}/configure \
	--host=${TARGET_SYS} \
	--windres=${MACHINE_DISPLAY_WIDTH_PIXELS}x${MACHINE_DISPLAY_HEIGHT_PIXELS} \
	--os=UNIX \
	--endian=${SITEINFO_ENDIANESS} \
	--prefix-dir=${prefix} \
	--binary-dir=bin \
	--with-midi=/bin/true \
	--with-zlib=${STAGING_LIBDIR} \
	--with-png \
	--with-freetype \
	--without-icu \
	--without-allegro \
	--cc-build=gcc \
	--cc-host=${TARGET_SYS}-gcc \
	--cxx-build=g++ \
	--cxx-host=${TARGET_SYS}-g++ \
	--strip=${TARGET_SYS}-strip \
	--install-dir=${D}
}

do_install() {
	oe_runmake install
}

do_install_append_shr() {
	install -d ${D}${datadir}/games/openttd/data/
	install -m 0644 ${WORKDIR}/openttd.cfg ${D}${datadir}/games/openttd/data/
}

FILES_${PN} += "${datadir}"
