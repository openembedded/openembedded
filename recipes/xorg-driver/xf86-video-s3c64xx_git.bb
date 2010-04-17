require xorg-driver-video.inc

PR_append = "a"

DESCRIPTION = "X.Org X server -- driver for the Samsung s3c64xx SoC family"

SRCREV = "79c2402ba26e57f4c9fd27f75f8a0324c72c13be"
PV = "0.0.2+${PR}+gitr${SRCREV}"

SRC_URI = "git://git.gitorious.org/xf86-video-s3c64xx/xf86-video-s3c64xx.git;protocol=http \
           file://0001-s3c64xx-update-for-resources-RAC-API-removal.patch;patch=1 \
           file://0002-DPMS-header-was-split-into-dpms.h-client-and-dpmscon.patch;patch=1 \
           file://0003-s3c64xx-lcd-include-cursorstr.h-to-get-CursorRec-and.patch;patch=1 \
          "

S = "${WORKDIR}/git"

CFLAGS += " -I${STAGING_INCDIR}/xorg "


