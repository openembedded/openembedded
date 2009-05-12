inherit gpe

DEPENDS = "libsoundgen libschedule gtk+ libgpewidget"
LICENSE = "GPL"
PR = "r1"

SRC_URI += " \
            file://fix-esound.diff;patch=1 \
            file://fix-install.diff;patch=1 \
           "
