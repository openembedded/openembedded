# Qt Embedded toolchain
PR = "${INC_PR}.0"
TOOLCHAIN_HOST_TASK = "task-qt-toolchain-host"
TOOLCHAIN_TARGET_TASK = "task-qte-toolchain-target"

require meta-toolchain.bb
SDK_SUFFIX = "toolchain-qte"
SDK_SUFFIX_angstrom = "toolchain-qte-${ANGSTROM_QT_VERSION}"

QT_DIR_NAME = "qtopia"
require meta-toolchain-qt.inc
