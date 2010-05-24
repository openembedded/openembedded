require xserver-kdrive-common.inc

DEPENDS += "hal libxkbfile libxcalibrate pixman"
RDEPENDS += "hal"

PE = "1"
PR = "${INC_PR}.1"

SRC_URI = "${XORG_MIRROR}/individual/xserver/xorg-server-${PV}.tar.bz2 \
	${KDRIVE_COMMON_PATCHES} \
	file://enable-epson.patch;apply=yes \
        file://fix_default_mode.patch;apply=yes \
	file://enable-xcalibrate.patch;apply=yes \
	file://hide-cursor-and-ppm-root.patch;apply=yes \
	file://xcalibrate_coords.patch;apply=yes \
	file://w100.patch;apply=yes \
	file://w100-autofoo.patch;apply=yes \
	file://w100-fix-offscreen-bmp.patch;apply=yes \
	file://w100-new-input-world-order.patch;apply=yes \
	file://linux-keyboard-mediumraw.patch;apply=yes \
	file://xcalibrate-new-input-world-order.patch;apply=yes \
	file://tslib-default-device.patch;apply=yes \
	file://fbdev-evdev.patch;apply=yes \
	file://keyboard-resume-workaround.patch;apply=yes \
	file://xorg-avr32-support.diff;apply=yes \
	file://pkgconfig_fix.patch;apply=yes \
        file://no_xkb.patch;apply=yes;striplevel=0 \
	file://vm86_masks.patch;apply=yes \
        "

S = "${WORKDIR}/xorg-server-${PV}"

W100_OECONF = "--disable-w100"
W100_OECONF_arm = "--enable-w100"

EXTRA_OECONF += "--enable-builtin-fonts"

SRC_URI[md5sum] = "fa2915ae377f61c340a18ebef484b64b"
SRC_URI[sha256sum] = "829c66ec4c295822700067c87afae796b8e67530cc65a7b83060ea29a4ff316d"
