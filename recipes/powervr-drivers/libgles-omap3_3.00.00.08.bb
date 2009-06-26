require libgles-omap3.inc

DEFAULT_PREFERENCE = "1"

SGXPV = "3_00_00_08"
IMGPV = "1.3.13.1607"

# Quality control is really poor on these SDKs, so hack around the latest madness:
FILES_${PN} += "${libdir}/*.so"
FILES_${PN}-dev = "${includedir}"

