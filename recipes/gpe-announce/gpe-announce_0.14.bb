inherit gpe

DEPENDS = "libsoundgen libschedule gtk+ libgpewidget"
LICENSE = "GPL"
PR = "r0"

SRC_URI += "file://fix-esound.diff;patch=1"

SRC_URI[md5sum] = "4ec782fb49dd0e5549817d9e8601f9fc"
SRC_URI[sha256sum] = "447c23943d4c004ceb25c7079058f79e270915cf6650e31c92498865dbed22a6"
