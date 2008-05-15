DESCRIPTION = "Zhone: Zen Phone"
LICENSE = "GPL"
SECTION = "x11"
DEPENDS = "edje-native"
RDEPENDS = "task-python-efl python-textutils"
PV = "0.0.0+gitr${SRCREV}"

SRC_URI = "${FREESMARTPHONE_GIT}/zhone.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools

FILES_${PN} += "${datadir}"
