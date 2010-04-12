DESCRIPTION = "Dialog-like functionality for Python Console Programs"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
SRCNAME = "pythondialog"
PR = "ml1"

SRC_URI = "${SOURCEFORGE_MIRROR}/${SRCNAME}/${SRCNAME}-${PV}.tar.bz2"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

SRC_URI[md5sum] = "19e68b362fe61ef84b981d53d96f0735"
SRC_URI[sha256sum] = "5f7dbcbd28eebadc736d957b9511a87ad5570c8fc822c8123a42e7259773cb7f"
