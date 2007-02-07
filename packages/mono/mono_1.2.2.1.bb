DESCRIPTION = "Mono Programming Language"
SECTION = "devel/mono"
LICENSE = "GPL LGPL X11"
DEPENDS = "mono-native glib-2.0"

#We only have a cpu-${arch}.h from arm, so let's mask out non-working architectures
COMPATIBLE_HOST = "arm.*-linux"

SRC_URI = "http://go-mono.com/sources/mono/mono-${PV}.tar.gz \
           file://cpu-arm.h"

inherit autotools

EXTRA_OECONF = "--disable-mcs-build"
EXTRA_OECONF_arm = "--without-tls"

do_compile_prepend() {
        cp ${WORKDIR}/cpu-arm.h ${S}/mono/mini/
}
