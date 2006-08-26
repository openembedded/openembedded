LICENSE = "GPL"

SRC_URI = "http://fabrice.bellard.free.fr/qemu/qemu-${PV}.tar.gz \
           file://configure.patch;patch=1 \
           file://pl110_rgb-r0.patch;patch=1 \
           file://arm_nptl.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--cc=${CC}"

