require xserver-kdrive-common.inc

DEPENDS += "hal libxkbfile libxcalibrate pixman"
RDEPENDS_${PN} += "hal"

DEFAULT_PREFERENCE = "-99" 

PE = "1"
PR = "${INC_PR}.1"

SRC_URI = "${XORG_MIRROR}/individual/xserver/xorg-server-${PV}.tar.bz2 \
	${KDRIVE_COMMON_PATCHES} \
	file://enable-epson.patch \
        file://fix_default_mode.patch \
#	file://hide-cursor-and-ppm-root.patch \
#	file://xcalibrate_coords.patch \
	file://w100.patch \
	file://w100-autofoo.patch \
	file://w100-fix-offscreen-bmp.patch \
	file://w100-new-input-world-order.patch \
	file://linux-keyboard-mediumraw.patch \
	file://xcalibrate-new-input-world-order.patch \
	file://tslib-default-device.patch \
#	file://fbdev-evdev.patch \
	file://keyboard-resume-workaround.patch \
	file://xorg-avr32-support.diff \
#	file://pkgconfig_fix.patch \
	file://no_xkb.patch;striplevel=0 \
        "

S = "${WORKDIR}/xorg-server-${PV}"

W100_OECONF = "--disable-w100"
#W100_OECONF_arm = "--enable-w100"

EXTRA_OECONF += "--enable-builtin-fonts \
		 --disable-dri2 \
		"

SRC_URI[md5sum] = "e548512ece2f2fd32e438fbbd8f5b857"
SRC_URI[sha256sum] = "8c5b0f58a7f4382f052df0f4fb352c26953402d3298ee69d2d7077b510e09099"
