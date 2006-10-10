DESCRIPTION = "Task packages for the Angstrom distribution"
PR = "r23"
ALLOW_EMPTY = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

BOOTMODULES_RRECOMMENDS ?= ""
DEBUG_APPS ?= ""
DEBUG_APPS += '${@base_conditional("DISTRO_TYPE", "release", "", "tslib-tests tslib-calibrate strace gdb procps",d)}'
EXTRA_STUFF ?= ""
PCMCIA_MANAGER ?= "pcmciautils"

PACKAGES = "\
    angstrom-base-depends \
    angstrom-base"

RDEPENDS_angstrom-base-depends = "\
    update-modules module-init-tools modutils-initscripts \
    sysvinit initscripts sysvinit-pidof \
    psplash \
    netbase dropbear \
    angstrom-version \
    ipkg ipkg-collateral \
    util-linux-mount util-linux-umount \
    procps \
    ${EXTRA_STUFF} \
    ${DEBUG_APPS} \
"

RDEPENDS_angstrom-base-depends_append_ipaq-pxa270 = " tiinit acx-firmware "
RDEPENDS_angstrom-base-depends_append_h4000 = " tiinit acx-firmware "
RDEPENDS_angstrom-base-depends_append_htcuniversal = " tiinit acx-firmware "

RRECOMMENDS_angstrom-base-depends = "\
    ${BOOTMODULES_RRECOMMENDS} \
    kernel-module-evdev \
    kernel-module-uinput \
    kernel-module-g-ether \
    kernel-module-af-packet \
"

