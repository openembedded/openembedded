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

SRC_URI[md5sum] = "ed87b7dd9f4fb482de0f14f085085027"
SRC_URI[sha256sum] = "558491d1f112362780abaf7429d14216e658b7768dd30f82f102ce646d3065cf"
SRC_URI[md5sum] = "021613030ae67c5c9868ec2a0c031172"
SRC_URI[sha256sum] = "a41c3eb4cf94fe7b059468983a2f533e0669d0204088fa5ece365b1663b560c7"
