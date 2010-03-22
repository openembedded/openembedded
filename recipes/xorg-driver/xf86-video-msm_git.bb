require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- MSM display driver"

PR_append = "d"

SRCREV = "5f7df59155ae301a3ebc40aec22ed16d203cb5fc"
PV = "1.1.0+${PR}+gitr${SRCREV}"
PE = "1"

SRC_URI = "git://codeaurora.org/quic/xwin/xf86-video-msm.git;protocol=git"
SRC_URI_htcdream = "git://codeaurora.org/quic/xwin/xf86-video-msm.git;protocol=git \
	file://no_neon.patch;patch=1 \
	file://no_neon_flags.patch;patch=1 \
	file://renaming_variables.patch;patch=1"

S = "${WORKDIR}/git"

CFLAGS += " -I${STAGING_INCDIR}/xorg "
CFLAGS += " -Wno-error "

ARM_INSTRUCTION_SET="arm"
