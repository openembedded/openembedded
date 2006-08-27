LICENSE = "GPL"

SRC_URI = "http://fabrice.bellard.free.fr/qemu/qemu-${PV}.tar.gz \
           file://configure.patch;patch=1 \
           file://arm_nptl.patch;patch=1"
PR = "r1"

inherit autotools

