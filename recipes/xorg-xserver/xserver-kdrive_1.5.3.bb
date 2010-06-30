require xserver-kdrive-common.inc

DEPENDS += "hal libxkbfile libxcalibrate pixman openssl"
RDEPENDS_${PN} += "hal"

DEFAULT_PREFERENCE = "-99" 

PE = "1"
PR = "${INC_PR}.2"

SRC_URI = "${XORG_MIRROR}/individual/xserver/xorg-server-${PV}.tar.bz2 \
	${KDRIVE_COMMON_PATCHES} \
	file://enable-epson.patch \
        file://fix_default_mode.patch \
	file://linux-keyboard-mediumraw.patch \
	file://xcalibrate-new-input-world-order.patch \
	file://tslib-default-device.patch \
	file://keyboard-resume-workaround.patch \
	file://xorg-avr32-support.diff \
	file://sysroot_fix.patch \
	file://drmfix.patch \
	file://no_xkb.patch \
	file://keyboard_device.patch \
	file://enable-xcalibrate.patch \
        "

S = "${WORKDIR}/xorg-server-${PV}"

MESA_VER = "7.2"

EXTRA_OECONF += "--enable-builtin-fonts \
		 --disable-glx \
         --disable-dri2 \
		"

SRC_URI[md5sum] = "308971036e25250e7fe3cccfd5a120f8"
SRC_URI[sha256sum] = "a680174f54be7763819e5275c5d5d44fc9e9b6f8e9351dd45c150eb4c182d5bb"
