DESCRIPTION = "Mono Programming Language"
SECTION = "devel/mono"
LICENSE = "GPL LGPL X11"

SRC_URI = "http://go-mono.com/sources/mono/mono-${PV}.tar.bz2"

S = "${WORKDIR}/mono-${PV}"

inherit autotools
EXTRA_OECONF_arm = "--without-tls"
EXTRA_OECONF_mipsel = "--without-tls"

