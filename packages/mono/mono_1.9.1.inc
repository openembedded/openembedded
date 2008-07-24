DESCRIPTION = "Mono Programming Language"
SECTION = "devel/mono"
LICENSE = "GPL LGPL X11"

SRC_URI = "http://ftp.novell.com/pub/mono/sources/mono/mono-1.9.1.tar.bz2 \
		"

#	   file://mono-libgc-configure.patch;patch=1"

S = "${WORKDIR}/mono-1.9.1"

inherit autotools
EXTRA_OECONF_arm = "--without-tls"
EXTRA_OECONF_mipsel = "--without-tls"

