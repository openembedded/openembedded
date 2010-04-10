require iqnotes.inc

#upstream version
UPV = "2.1.0rc1"
PR = "r2"

SRC_URI = "http://download.berlios.de/iqnotes/iqnotes-${UPV}.tar.bz2 \
           file://pro.patch;patch=1"

S = "${WORKDIR}/iqnotes-${UPV}/iqnotes/"

EXTRA_QMAKEVARS_POST += "CONFIG-=desktop CONFIG-=debug CONFIG+=pda LIBS-=-lqtopia"

SRC_URI[md5sum] = "6b4bbf1b97d1fe777c881c0576e4cb65"
SRC_URI[sha256sum] = "e3c0d1991f6a35f789bf305bc56971e2ced6208d19443ccea8d1d64417a90faf"
