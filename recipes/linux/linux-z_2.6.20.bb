DESCRIPTION = "2.6 Linux Development Kernel for the DNARD/Shark, SIMpad."
SECTION = "kernel"
LICENSE = "GPLv2"

inherit kernel

S = "${WORKDIR}/git"
SRC_URI = "git://www.openembedded.org/~zecke/git/linux/linux-2.6/.git;protocol=http \
           file://defconfig"


RPROVIDES_kernel-image += "hostap-modules"

COMPATIBLE_HOST = "(arm).*-linux"
COMPATIBLE_MACHINE = '(shark)'




do_configure_prepend() {
    install -m 0644 ${WORKDIR}/defconfig ${S}/.config
}
