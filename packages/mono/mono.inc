DESCRIPTION = "Mono Programming Language"
SECTION = "devel/mono"
LICENSE = "GPL LGPL X11"

SRC_URI = "http://go-mono.com/sources/mono/mono-${PV}.tar.gz \
           file://cpu-arm.h"

S = "${WORKDIR}/mono-${PV}"

inherit autotools

EXTRA_OECONF = "--disable-mcs-build"
EXTRA_OECONF_arm = "--without-tls"

do_compile_prepend() {
        cp ${WORKDIR}/cpu-arm.h ${S}/mono/mini/
}
