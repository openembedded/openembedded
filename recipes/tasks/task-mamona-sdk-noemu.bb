PR = "r2"

require mamona-sdk.inc

RCONFLICTS = "task-mamona-sdk"
RREPLACES = "task-mamona-sdk"

RDEPENDS_${PN} += "\
  bash-noemu \
  binutils-noemu \
  binutils-noemu-symlinks \
  gcc-noemu \
  gcc-noemu-symlinks \
  g++-noemu \
  g++-noemu-symlinks \
"
