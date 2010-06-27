require xorg-driver-video.inc
DESCRIPTION = "X.Org X server -- MSM display driver"
PE = "1"
PV = "1.1.0+${PR}+gitr${SRCREV}"
PR = "${INC_PR}.0"

SRC_URI = "git://codeaurora.org/quic/xwin/xf86-video-msm.git;protocol=git;branch=chromium \
           file://compile_cfbbd17f0d4ab0f30915594d74e1b2b12c4ff8a1.patch \
           file://kgsl_drm.h "
SRC_URI_append_htcdream = "file://no_neon_cfbbd17f0d4ab0f30915594d74e1b2b12c4ff8a1.patch"

SRCREV = "cfbbd17f0d4ab0f30915594d74e1b2b12c4ff8a1"
S = "${WORKDIR}/git"

do_compile_prepend() {
        install -d ${S}/src/linux
        install -d ${S}/src/drm
        install -m 0644 ${STAGING_KERNEL_DIR}/include/linux/msm_mdp.h ${S}/src/linux/
        install -m 0644 ${WORKDIR}/kgsl_drm.h ${S}/src/drm/
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

ARM_INSTRUCTION_SET = "arm"

CFLAGS += " -I${STAGING_INCDIR}/xorg "
CFLAGS += " -Wno-error "
