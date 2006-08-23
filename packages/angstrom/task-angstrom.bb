DESCRIPTION = "Task packages for the Angstrom distribution"
PR = "r19"
ALLOW_EMPTY = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

BOOTMODULES_RRECOMMENDS ?= ""
DEBUG_APPS ?= ""
DEBUG_APPS += '${@base_conditional("DISTRO_TYPE", "release", "", "strace gdb procps",d)}'
EXTRA_STUFF ?= ""
PCMCIA_MANAGER ?= "pcmciautils"

PACKAGES = "\
    angstrom-base-depends \
    angstrom-base-wifi "

RDEPENDS_angstrom-base-depends = "\
    base-files keymaps \
    base-passwd tinylogin \
    busybox \
    udev \
    update-modules module-init-tools modutils-initscripts \
    sysvinit initscripts sysvinit-pidof \
    netbase dropbear \
    angstrom-version \
    ipkg ipkg-collateral \
    tslib-tests tslib-calibrate \
    util-linux-mount util-linux-umount \
    ${EXTRA_STUFF} \
    ${DEBUG_APPS} \
    ${PCMCIA_MANAGER} \
    angstrom-base-wifi \
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

RDEPENDS_angstrom-base-wifi = "\
    hostap-utils \
    hostap-conf \
    prism3-support \
    prism3-firmware \
    wireless-tools \
    wpa-supplicant \
    "

RRECOMMENDS_angstrom-base-wifi = "\
    kernel-module-hostap-cs \
    kernel-module-orinoco-cs \
    kernel-module-spectrum-cs \
    kernel-module-arc4 \
    kernel-module-michael-mic \
    kernel-module-aes \
    kernel-module-ieee80211-crypt-tkip \
    kernel-module-ieee80211-crypt-wep \
    kernel-module-ieee80211-crypt \
    kernel-module-ieee80211-crypt-ccmp \
"
