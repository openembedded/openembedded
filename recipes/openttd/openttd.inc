DESCRIPTION = "Open source clone of the Microprose game 'Transport Tycoon Deluxe' - SDL edition."
HOMEPAGE = "http://www.openttd.org"
LICENSE = "GPLv2"
DEPENDS = "libsdl-net libpng zlib lzo2 freetype fontconfig"

RRECOMMENDS_${PN} = "openttd-gfx openttd-sfx"

SRC_URI ="http://binaries.openttd.org/releases/${PV}/${P}-source.tar.gz"

APPIMAGE = "media/openttd.128.png"

inherit siteinfo sdl

# OpenTTD uses a self-made build system (meh!) that looks like the autotools.
# When messing with it be careful not to expect it to behave the same!
do_configure() {
  # The way the OTTD configure system handles the application's directories
  # isn't the way autotools does it. Mainly prefix is always prepended even if
  # absolute binary-dir and data-dir is given.

  # The build system does not forgive unknown options.

  ${S}/configure \
	--host=${TARGET_SYS} \
	--windres=${MACHINE_DISPLAY_WIDTH_PIXELS}x${MACHINE_DISPLAY_HEIGHT_PIXELS} \
	--os=UNIX \
	--endian=${SITEINFO_ENDIANNESS} \
	--prefix-dir=${prefix} \
	--binary-dir=bin \
	--with-midi=/bin/true \
	--with-zlib=${STAGING_LIBDIR} \
	--with-png \
	--with-freetype \
	--with-liblzo2=${STAGING_LIBDIR} \
	--without-icu \
	--without-allegro \
	--cc-build='${BUILD_CC}' \
	--cc-host='${CC}' \
	--cxx-build='${BUILD_CXX}' \
	--cxx-host='${CXX}' \
	--strip='${STRIP}' \
	--install-dir=${D} \
	${EXTRA_OECONF}
}

do_install() {
	oe_runmake install
}

FILES_${PN} += "${datadir}"

