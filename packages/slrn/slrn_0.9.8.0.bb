LICENSE = "GPL"
DESCRIPTION = "slrn - console news reader"
SECTION = "console/network"
PRIORITY = "optional"
MAINTAINER = "Graeme Gregory <xora@lordpain.uklinux.net>"
DEPENDS = "slang"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/slrn/slrn-${PV}.tar.bz2 \
	   file://m4.patch;patch=1 \
	   file://chkslang.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--enable-setgid-code --enable-spool --with-slrnpull \
		--with-slang-library=${STAGING_LIBDIR} \
		--with-slang-includes=${STAGING_INCDIR}"
