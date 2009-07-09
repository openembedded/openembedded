DESCRIPTION = "Simple ffmpeg-based player that uses the omapfb overlays"
DEPENDS = "libxv bzip2 lame ffmpeg virtual/kernel"
LICENSE = "MIT"

PR = "r1"
PV = "0.0+${PR}+gitr${SRCREV}"

SRCREV = "e66bf25df1f1ff085e6db102b282d90e7ceff4bf"
SRC_URI = "git://git.mansr.com/omapfbplay;protocol=git \
"

S = "${WORKDIR}/git"

# We want a kernel header for armv7a, but we don't want to make mplayer machine specific for that
STAGING_KERNEL_DIR = "${STAGING_DIR}/${MACHINE_ARCH}${TARGET_VENDOR}-${TARGET_OS}/kernel"

CFLAGS += " -I. -I${STAGING_KERNEL_DIR}/include "

do_compile() {
	cp ${STAGING_KERNEL_DIR}/arch/arm/plat-omap/include/mach/omapfb.h ${S} || true
	cp ${STAGING_KERNEL_DIR}/include/asm-arm/arch-omap/omapfb.h ${S} || true
	cp ${STAGING_KERNEL_DIR}/include/linux/omapfb.h ${S} || true
	oe_runmake OMAPFB=y XV=y NETSYNC=y -e
}

do_install() {
	install -d ${D}/${bindir}
	install -m 0755 ${S}/omapfbplay ${D}/${bindir}/omapfbplay-xv
}
