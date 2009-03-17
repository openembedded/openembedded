DESCRIPTION = "MRXVT is a lightweight and powerful X terminal emulator based on aterm and rxvt"
HOMEPAGE = "http://materm.sourceforge.net"
AUTHOR = "Jimmy Zhou <jimmyzhou@users.sf.net>"
LICENSE = "GPL"
SECTION = "x11/applications"
DEPENDS = "freetype fontconfig libxft virtual/libx11"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/materm/mrxvt-${PV}.tar.gz \
           ${SOURCEFORGE_MIRROR}/materm/no_debug_x.patch;pnum=0;patch=1 \
           file://fix-compile.patch;patch=1 \
           file://font-defaults.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--x-includes=${STAGING_INCDIR}/X11 \
		--x-libraries=${STAGING_LIBDIR} \
		--enable-everything \
		--disable-debug"
