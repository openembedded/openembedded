inherit gpe

DEPENDS = "libsoundgen libschedule gtk+ libgpewidget"
LICENSE = "GPL"
FILE_PR = "r1"

SRC_URI += "file://fix-esound.diff;patch=1"
