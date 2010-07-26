SRCREV = "c13fffff4d95067acd45ae51e075b0bf71b01dee"
PV = "0.0.4+gitr${SRCREV}"
PR = "${INC_PR}.0"

S = "${WORKDIR}/git"

#SRC_URI = "git://bcusdk.git.sourceforge.net/gitroot/bcusdk/bcusdk;protocol=git;branch=master"
SRC_URI = "git://bcusdk.git.sourceforge.net/gitroot/bcusdk/bcusdk;protocol=git;branch=pu"

SRC_URI += "file://disable-python-pascal.patch"

require eibd.inc
