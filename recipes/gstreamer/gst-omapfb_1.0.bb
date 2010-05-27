DESCRIPTION = "GST output sink for Omapfb"
LICENSE = "GPL"

inherit autotools

DEPENDS = "gstreamer virtual/libx11 virtual/kernel"

SRCREV = "6f0b1cb50d1c67c3a3db2f11246256060ac871de"
PV = "0.0+${PR}+gitr${SRCREV}"

SRC_URI = "git://github.com/felipec/${PN}.git;protocol=git \
           file://0001-Implement-XOverlay-and-I420-to-422-colorspace-conver.patch"

S  ="${WORKDIR}/git"

# We want a kernel header for armv7a, but we don't want to make gst-omapfb machine specific for that
STAGING_KERNEL_DIR = "${STAGING_DIR}/${MACHINE_ARCH}${TARGET_VENDOR}-${TARGET_OS}/kernel"

EXTRA_OEMAKE = " KERNEL=${STAGING_KERNEL_DIR}"
CFLAGS += "-I${S}"

TARGET_CC_ARCH += "${CFLAGS} ${LDFLAGS}"

do_configure_prepend() {
	install -d ${S}/linux
    cp ${STAGING_KERNEL_DIR}/arch/arm/plat-omap/include/mach/omapfb.h ${S}/linux || true
    cp ${STAGING_KERNEL_DIR}/include/asm-arm/arch-omap/omapfb.h ${S}/linux || true
    cp ${STAGING_KERNEL_DIR}/include/linux/omapfb.h ${S}/linux || true
 	sed -e 's/__user//g' -i ${S}/linux/omapfb.h
}

do_install() {
	install -d ${D}${libdir}/gstreamer-0.10
	install -m 0755 libgstomapfb.so ${D}${libdir}/gstreamer-0.10
}

FILES_${PN} += "${libdir}/gstreamer-0.10/libgstomapfb.so"
FILES_${PN}-dbg += "${libdir}/gstreamer-0.10/.debug"
