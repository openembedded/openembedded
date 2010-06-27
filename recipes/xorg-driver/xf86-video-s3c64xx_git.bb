require xorg-driver-video.inc
DESCRIPTION = "X.Org X server -- driver for the Samsung s3c64xx SoC family"
PV = "0.0.2+${PR}+gitr${SRCREV}"
PR = "${INC_PR}.0"

SRC_URI = "git://git.gitorious.org/xf86-video-s3c64xx/xf86-video-s3c64xx.git;protocol=http \
           file://0001-s3c64xx-update-for-resources-RAC-API-removal.patch \
           file://0002-DPMS-header-was-split-into-dpms.h-client-and-dpmscon.patch \
           file://0003-s3c64xx-lcd-include-cursorstr.h-to-get-CursorRec-and.patch \
          "

SRCREV = "79c2402ba26e57f4c9fd27f75f8a0324c72c13be"
S = "${WORKDIR}/git"

CFLAGS += " -I${STAGING_INCDIR}/xorg "
