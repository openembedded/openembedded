DESCRIPTION = "SourceCode Test Utility"
SECTION = "devel/python"
HOMEPAGE = "http://pychecker.sourceforge.net/"
PRIORITY = "optional"
LICENSE = "BSD"
SRCNAME = "pychecker"
PR = "ml0"

SRC_URI = "${SOURCEFORGE_MIRROR}/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

SRC_URI[md5sum] = "ef156a631df46de150a364912f2e36c8"
SRC_URI[sha256sum] = "6495fe464659b175cefce20b187de6904b97b065fd609445b932d9c49a75a024"
