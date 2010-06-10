PR = "r3"

require mamona-sdk.inc

RCONFLICTS_${PN} = "task-mamona-sdk"
RREPLACES_${PN} = "task-mamona-sdk"

RDEPENDS_${PN} += "\
  bash-noemu \
  binutils-noemu \
  binutils-noemu-symlinks \
  gcc-noemu \
  gcc-noemu-symlinks \
  g++-noemu \
  g++-noemu-symlinks \
"
