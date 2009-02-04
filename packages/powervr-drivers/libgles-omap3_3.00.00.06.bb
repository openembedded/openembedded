require libgles-omap3.inc

# Not released yet
DEFAULT_PREFERENCE = "-1"
PR = "r2"

SGXPV = "3_00_00_06"

do_accept_license() {
    export HOME="${WORKDIR}"
    echo "Y
q
Y
${S}" | ${WORKDIR}/OMAP35x_Graphics_SDK_setuplinux_${SGXPV}.bin
}

# Quality control is really poor on these SDKs, so hack around the latest madness:
FILES_${PN} += "${libdir}/*.so"
FILES_${PN}-dev = "${includedir}"

