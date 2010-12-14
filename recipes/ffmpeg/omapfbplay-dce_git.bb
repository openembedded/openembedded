DESCRIPTION = "Simple ffmpeg-based player that uses the omapfb overlays"
DEPENDS = "libdce bzip2 lame ffmpeg virtual/kernel"
LICENSE = "MIT"

PR = "r0"

PV = "0.0+${PR}+gitr${SRCREV}"

SRCREV = "1d217676ba71e8740524e9814c47da39880ed3bc"
SRC_URI = "git://git.mansr.com/omapfbplay;protocol=git \
"

S = "${WORKDIR}/git"

# We want a kernel header for armv7a, but we don't want to make mplayer machine specific for that
STAGING_KERNEL_DIR = "${STAGING_DIR}/${MACHINE_ARCH}${TARGET_VENDOR}-${TARGET_OS}/kernel"

CFLAGS += " -I. -I${STAGING_INCDIR}/dce -I${STAGING_KERNEL_DIR}/include "

do_compile() {
	cp ${STAGING_KERNEL_DIR}/arch/arm/plat-omap/include/mach/omapfb.h ${S} || true
	cp ${STAGING_KERNEL_DIR}/include/asm-arm/arch-omap/omapfb.h ${S} || true
	cp ${STAGING_KERNEL_DIR}/include/linux/omapfb.h ${S} || true
	oe_runmake ${TARGET_ARCH}=y V4L2=y OMAPFB=y NETSYNC=y DCE=y -e
}

do_install() {
	install -d ${D}/${bindir}
	install -m 0755 ${S}/omapfbplay ${D}/${bindir}/omapfbplay-dce
}
