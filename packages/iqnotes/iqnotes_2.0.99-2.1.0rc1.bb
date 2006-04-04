include iqnotes.inc

#upstream version
UPV = "2.1.0rc1"
PR = "r1"

SRC_URI = "http://download.berlios.de/iqnotes/iqnotes-${UPV}.tar.bz2 \
           file://pro.patch;patch=1"

S = "${WORKDIR}/iqnotes-${UPV}/iqnotes/"

EXTRA_QMAKEVARS_POST += "CONFIG-=desktop CONFIG-=debug CONFIG+=pda LIBS-=-lqtopia"
