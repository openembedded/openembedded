PR = "r4"

include mamona-sdk.inc

RCONFLICTS = "task-mamona-sdk-noemu"
RREPLACES = "task-mamona-sdk-noemu"

RDEPENDS += "\
  bash \
  binutils \
  binutils-symlinks \
  gcc \
  gcc-symlinks \
  g++ \
  g++-symlinks \
"
