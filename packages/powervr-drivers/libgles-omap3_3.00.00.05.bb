require libgles-omap3.inc

# Not released yet
DEFAULT_PREFERENCE = "-1"
PR = "r3"

SGXPV = "3_00_00_05"
IMGPV = "1.2.12.838"

# Quality control is really poor on these SDKs, so hack around the latest madness:
FILES_${PN} += "${libdir}/*.so"
FILES_${PN}-dev = "${includedir}"
