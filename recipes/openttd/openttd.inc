# Note: OpenTTD's build system changed considerably in 0.6.x
# This include file is written towards the newer versions.

DESCRIPTION = "Open source clone of the Microprose game 'Transport Tycoon Deluxe' - SDL edition. \
This package provides the engine only.  You will need to get the data file elsewhere \
through official channels."
HOMEPAGE = "http://openttd.sf.net"
LICENSE = "GPLv2"

DEPENDS = "libsdl-net libpng zlib freetype fontconfig"

SRC_URI = "http://binaries.openttd.org/releases/${PV}/${P}-source.tar.bz2"

APPIMAGE = "media/openttd.48.png"

inherit siteinfo sdl

do_configure() {
	# The way the OTTD configure system handles the application's directories
  # isn't the way autotools does it. Mainly prefix is always prepended even if
  # absolute binary-dir and data-dir is given. Sigh ...

	# Disabling MIDI feature for now.
  ./configure \
    --build=${BUILD_SYS} \
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

FILES_${PN} += "${datadir}/*"
