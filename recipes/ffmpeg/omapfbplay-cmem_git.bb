DESCRIPTION = "Simple ffmpeg-based player that uses the omapfb overlays"
DEPENDS = "ti-linuxutils bzip2 lame ffmpeg virtual/kernel"
LICENSE = "MIT"

PV = "0.0+${PR}+gitr${SRCREV}"

SRCREV = "70bc185cfc3dd64399dc664a90a56a15796fb2e8"
SRC_URI = "git://git.mansr.com/omapfbplay;protocol=git \
"

S = "${WORKDIR}/git"

require ../ti/ti-paths.inc

PACKAGE_ARCH = "${MACHINE_ARCH}"

SDMA_CFLAGS = " -I${LINUXUTILS_INSTALL_DIR}/packages/ti/sdo/linuxutils/sdma/include/"
CMEM_CFLAGS = " -I${LINUXUTILS_INSTALL_DIR}/packages/ti/sdo/linuxutils/cmem/include/"
CFLAGS += " -I. -I${STAGING_KERNEL_DIR}/include ${SDMA_CFLAGS} ${CMEM_CFLAGS}"

export SDMA_LIBS = "-L${LINUXUTILS_INSTALL_DIR}/packages/ti/sdo/linuxutils/sdma/lib -l:sdma.a470MV"
export CMEM_LIBS = "-L${LINUXUTILS_INSTALL_DIR}/packages/ti/sdo/linuxutils/cmem/lib -l:cmem.a470MV"

do_compile() {
	cp ${STAGING_KERNEL_DIR}/arch/arm/plat-omap/include/mach/omapfb.h ${S} || true
	cp ${STAGING_KERNEL_DIR}/include/asm-arm/arch-omap/omapfb.h ${S} || true
	cp ${STAGING_KERNEL_DIR}/include/linux/omapfb.h ${S} || true
	oe_runmake arm=y OMAPFB=y NETSYNC=y CMEM=y SDMA=y -e
}

do_install() {
	install -d ${D}/${bindir}
	install -m 0755 ${S}/omapfbplay ${D}/${bindir}/${PN}
}
