require xorg-app-common.inc
DESCRIPTION = "X display manager"
DEPENDS += " libxmu libxinerama libxpm libxdmcp libxau libxext libxdmcp libxt libxaw"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "329383040cdbda5b5c8ce6c7e1120c97"
SRC_URI[archive.sha256sum] = "1487f7168e65fb7ea8cf21e99cdec412e643680c5dac9688aad5f87beba4f97f"

EXTRA_OECONF += "\
        --with-random-device=/dev/urandom --with-utmp-file=/var/run/utmp \
        --with-wtmp-file=/var/log/wtmp \
        "

FILES_${PN}-dbg += "${libdir}/X11/xdm/.debug/*"
