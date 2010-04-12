DESCRIPTION = "xterm is the standard terminal emulator for the X Window System."
SECTION = "x11/applications"
LICENSE = "MIT-X"

DEPENDS = "libxaw xproto virtual/libx11 xextproto xext xau libxpm ncurses"

SRC_URI = "ftp://invisible-island.net/xterm/${PN}-${PV}.tgz"

inherit autotools pkgconfig

FILES_${PN} += " /usr/lib/X11"

EXTRA_OECONF = " --x-includes=${STAGING_INCDIR} \
                 --x-libraries=${STAGING_LIBDIR} \
                 FREETYPE_CONFIG=${STAGING_BINDIR_CROSS}/freetype-config \
                 --disable-imake \
                 --disable-setuid"

do_configure() {

	sed -e "s%/usr/contrib/X11R6%${STAGING_LIBDIR}%g" -i configure

	oe_runconf
}

do_stage() {
	autotools_stage_all
}

SRC_URI[md5sum] = "343a4ce213f70c53cf65979f163bebc3"
SRC_URI[sha256sum] = "2ff9a4ae66cf9a48829023d1d007b0e84ee9cc60feb48107f9c1ea9dd7570ce7"
