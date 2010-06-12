PR = "r5"

include mamona-sdk.inc

RCONFLICTS_${PN} = "task-mamona-sdk-noemu"
RREPLACES_${PN} = "task-mamona-sdk-noemu"

RDEPENDS_${PN} += "\
  bash \
  binutils \
  binutils-symlinks \
  gcc \
  gcc-symlinks \
  g++ \
  g++-symlinks \
"
