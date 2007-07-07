DESCRIPTION = "Qemu is an open source processor emulator."
HOMEPAGE = "http://fabrice.bellard.free.fr/qemu/"
SECTION = "devel"
LICENSE = "GPL"
SRCDATE="20070701"
PV = "0.9.0+cvs${SRCDATE}"
PR = "r1"

SRC_URI = "cvs://anonymous@cvs.savannah.nongnu.org/sources/qemu;method=pserver;rsh=ssh;module=qemu;date=${SRCDATE} \
           file://configure-0.9.0.patch;patch=1 \
           file://qemu-sdl-cursor-0.9.0.patch;patch=1 \
           file://arm_nptl-0.9.0.patch;patch=1 \
           file://pl110_rgb-r0-0.9.0.patch;patch=1 \
           file://qemu-0.9.0-gcc4.patch;patch=1 \
	   file://qemu-amd64-32b-mapping-0.9.0.patch;patch=1"
S = "${WORKDIR}/qemu"

EXTRA_OECONF="--disable-gcc-check"

inherit autotools

DEFAULT_PREFERENCE = "-1"
