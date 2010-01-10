require xserver-kdrive-common.inc

DEPENDS += "hal libxkbfile libxcalibrate pixman"
RDEPENDS += "hal"

DEFAULT_PREFERENCE = "-99" 

PE = "1"
PR = "${INC_PR}.0"

SRC_URI = "${XORG_MIRROR}/individual/xserver/xorg-server-${PV}.tar.bz2 \
	${KDRIVE_COMMON_PATCHES} \
	file://enable-epson.patch;patch=1 \
        file://fix_default_mode.patch;patch=1 \
	file://linux-keyboard-mediumraw.patch;patch=1 \
	file://xcalibrate-new-input-world-order.patch;patch=1 \
	file://tslib-default-device.patch;patch=1 \
	file://keyboard-resume-workaround.patch;patch=1 \
	file://xorg-avr32-support.diff;patch=1 \
    file://sysroot_fix.patch;patch=1 \
    file://drmfix.patch;patch=1 \
        "

S = "${WORKDIR}/xorg-server-${PV}"

MESA_VER = "7.2"

EXTRA_OECONF += "--enable-builtin-fonts \
		 --disable-glx \
         --disable-dri2 \
		"
