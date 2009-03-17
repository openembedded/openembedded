require libgles-omap3.inc

SGXPV = "3_00_00_01"

PR = "r7"

# Quality control is really poor on these SDKs, so hack around the latest madness:
FILES_${PN} += "${libdir}/*.so"
FILES_${PN}-dev = "${includedir}"

