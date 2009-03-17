DESCRIPTION = "Mono Programming Language"
SECTION = "devel/mono"
LICENSE = "GPL LGPL X11"

SRC_URI = "http://go-mono.com/sources/mono/mono-1.2.6.tar.bz2 \
	   file://mono-libgc-configure.patch;patch=1"

S = "${WORKDIR}/mono-1.2.6"

inherit autotools
ARM_INSTRUCTION_SET = "arm"
EXTRA_OECONF_arm = "--without-tls"
EXTRA_OECONF_mipsel = "--without-tls"

