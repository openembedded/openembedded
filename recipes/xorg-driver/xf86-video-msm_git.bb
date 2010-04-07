require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- MSM display driver"

PR_append = "e"

SRCREV = "cfbbd17f0d4ab0f30915594d74e1b2b12c4ff8a1"
PV = "1.1.0+${PR}+gitr${SRCREV}"
PE = "1"

SRC_URI = "git://codeaurora.org/quic/xwin/xf86-video-msm.git;protocol=git;branch=chromium \
           file://compile_cfbbd17f0d4ab0f30915594d74e1b2b12c4ff8a1.patch;patch=1 \
           file://kgsl_drm.h "

SRC_URI_append_htcdream = "file://no_neon_cfbbd17f0d4ab0f30915594d74e1b2b12c4ff8a1.patch;patch=1"

S = "${WORKDIR}/git"

CFLAGS += " -I${STAGING_INCDIR}/xorg "
CFLAGS += " -Wno-error "

ARM_INSTRUCTION_SET="arm"

PACKAGE_ARCH="${MACHINE_ARCH}"

do_compile_prepend() {
	install -d ${S}/src/linux
	install -d ${S}/src/drm
	install -m 0644 ${STAGING_KERNEL_DIR}/include/linux/msm_mdp.h ${S}/src/linux/
	install -m 0644 ${WORKDIR}/kgsl_drm.h ${S}/src/drm/
}
