DESCRIPTION = "PRU sw example applications"
HOMEPAGE = "https://gforge.ti.com/gf/project/pru_sw/"
LICENSE = "BSD"
DEPENDS += "ti-pru-sw-app-loader ti-pru-sw-edma-library"
RDEPENDS += "ti-pru-sw-edma-driver kernel-module-uio-pru"
PR = "r4+svnr${SRCPV}"

COMPATIBLE_MACHINE = "omapl138"

SRC_URI = "svn://gforge.ti.com/svn/pru_sw/;module=trunk;proto=https;user=anonymous;pswd=''"

SRCREV = "24"
S = "${WORKDIR}/trunk"

do_compile () {
        make -C ${S}/example_apps \
          CC="${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}gcc ${TOOLCHAIN_OPTIONS}" \
          BINDIR_APPLICATIONS="${S}/example_apps/bin" \
          BINDIR_FW="${S}/example_apps/bin" \
          UTILS_DIR="${S}/utils"
}

do_install () {
        install -d ${D}/usr/share/ti/ti-pru-eg/
        install -m 0755 ${S}/example_apps/bin/* ${D}/usr/share/ti/ti-pru-eg/
}

FILES_${PN} += "${datadir}/ti/ti-pru-eg/*"
FILES_${PN}-dbg += "${datadir}/ti/ti-pru-eg/.debug/*"
