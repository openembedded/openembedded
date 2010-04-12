DESCRIPTION = "xterm is the standard terminal emulator for the X Window System."
SECTION = "x11/applications"
LICENSE = "MIT-X"

DEPENDS = "libxaw xproto virtual/libx11 xextproto xext xau libxpm ncurses"

SRC_URI = "${XORG_MIRROR}/development/X11R7.0-RC4/extras/${PN}-${PV}.tar.gz"

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

SRC_URI[md5sum] = "3de8a3756c284a46a08c6d0308909486"
SRC_URI[sha256sum] = "652f579171e6e8f73c13ab6b060d2447ae35ebfbd39a6002b7c05a1dfc0f7eb8"
