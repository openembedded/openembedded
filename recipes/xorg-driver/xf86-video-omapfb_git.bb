require xorg-driver-video.inc
DESCRIPTION = "X.Org X server -- OMAP display driver"
PE = "1"
PV = "0.1.1+${PR}+gitr${SRCREV}"
PR = "${INC_PR}.2"

SRC_URI = "git://git.pingu.fi/xf86-video-omapfb.git;protocol=http \
           file://0001-blacklist-tv-out.patch \
           file://0002-Revert-Set-virtual-size-when-configuring-framebuffer.patch \
           file://0003-force-plain-mode.patch \
          "

SRCREV = "044617665d6737f4909aab96f91b06261dff05d2"
S = "${WORKDIR}/git"

EXTRA_OECONF_armv7a = " --enable-neon "

# Use overlay 2 on omap3 to enable other apps to use overlay 1 (e.g. dmai or omapfbplay)
do_compile_prepend_armv7a () {
        sed -i -e s:fb1:fb2:g ${S}/src/omapfb-xv.c
}

CFLAGS += " -I${STAGING_INCDIR}/xorg "
