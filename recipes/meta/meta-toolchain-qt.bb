# Qt X11 toolchain
PR = "${INC_PR}.0"
TOOLCHAIN_HOST_TASK = "task-qt-toolchain-host"
TOOLCHAIN_TARGET_TASK = "task-qt-toolchain-target"

require meta-toolchain.bb
SDK_SUFFIX = "toolchain-qt"
SDK_SUFFIX_angstrom = "toolchain-qt-${ANGSTROM_QT_VERSION}"

QT_DIR_NAME = "qt4"
require meta-toolchain-qt.inc
