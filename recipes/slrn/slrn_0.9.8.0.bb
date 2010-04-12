LICENSE = "GPL"
DESCRIPTION = "slrn - console news reader"
SECTION = "console/network"
PRIORITY = "optional"
DEPENDS = "slang"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/slrn/slrn-${PV}.tar.bz2 \
	   file://m4.patch;patch=1 \
	   file://chkslang.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--enable-setgid-code --enable-spool --with-slrnpull \
		--with-slang-library=${STAGING_LIBDIR} \
		--with-slang-includes=${STAGING_INCDIR}"

SRC_URI[md5sum] = "47e9931771114ba192356a0473e9649e"
SRC_URI[sha256sum] = "b97ea8385c4c9db64d69a84fcf87e5ffd98239932c88ff19f2e4c107ae24cdb2"
