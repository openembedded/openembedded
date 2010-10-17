require xserver-kdrive-common.inc

DEPENDS += "hal libxkbfile libxcalibrate pixman"
RDEPENDS_${PN} += "hal"

PE = "1"
PR = "${INC_PR}.1"

SRC_URI = "${XORG_MIRROR}/individual/xserver/xorg-server-${PV}.tar.bz2 \
	${KDRIVE_COMMON_PATCHES} \
	file://enable-epson.patch \
        file://fix_default_mode.patch \
	file://enable-xcalibrate.patch \
	file://hide-cursor-and-ppm-root.patch \
	file://xcalibrate_coords.patch \
	file://w100.patch \
	file://w100-autofoo.patch \
	file://w100-fix-offscreen-bmp.patch \
	file://w100-new-input-world-order.patch \
	file://linux-keyboard-mediumraw.patch \
	file://xcalibrate-new-input-world-order.patch \
	file://tslib-default-device.patch \
	file://fbdev-evdev.patch \
	file://keyboard-resume-workaround.patch \
	file://xorg-avr32-support.diff \
	file://pkgconfig_fix.patch \
        file://no_xkb.patch;striplevel=0 \
	file://xorg-1.4-kdrive-rotation.patch \
	file://split_multiple_AC_SUBST.patch \
	file://vm86_masks.patch \
	file://at91sam9-kmode.patch \
	file://wvga-kmode.patch \
        "

S = "${WORKDIR}/xorg-server-${PV}"

W100_OECONF = "--disable-w100"
W100_OECONF_arm = "--enable-w100"

EXTRA_OECONF += "--enable-builtin-fonts"

SRC_URI[md5sum] = "bb16e969850dbb5d3805cb88d35656d0"
SRC_URI[sha256sum] = "b89f2d17be5ba71e3cc25379e18155c55ea36ba94ac1abae953214f13c020ffe"
