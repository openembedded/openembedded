require xorg-driver-video.inc
DESCRIPTION = "X.Org X server -- OMAP display driver"
PE = "1"
PV = "0.1.1+${PR}+gitr${SRCREV}"
PR = "${INC_PR}.0"

SRC_URI = "git://git.pingu.fi/xf86-video-omapfb.git;protocol=http \
          "

SRCREV = "db636c8436265c3d86c5b8e00785e45d55825c80"
S = "${WORKDIR}/git"

EXTRA_OECONF_armv7a = " --enable-neon "

# Use overlay 2 on omap3 to enable other apps to use overlay 1 (e.g. dmai or omapfbplay)
do_compile_prepend_armv7a () {
        sed -i -e s:fb1:fb2:g ${S}/src/omapfb-xv.c
}

CFLAGS += " -I${STAGING_INCDIR}/xorg "
