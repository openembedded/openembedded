inherit gpe

DEPENDS = "libsoundgen libschedule gtk+ libgpewidget"
LICENSE = "GPL"
PR = "r0"

SRC_URI += "file://fix-esound.diff;patch=1"
