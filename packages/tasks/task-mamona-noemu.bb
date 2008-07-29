DESCRIPTION = "Noemu packages are i386 packages thar run inside ARM chroot environment"
LICENSE = "MIT"
PR = "r1"
ALLOW_EMPTY = "1"

PACKAGES = "${PN}"
RCONFLICTS = "task-mamona-sdk task-mamona-base task-mamona"

RDEPENDS = "\
  bash-noemu \
  binutils-noemu \
  binutils-noemu-symlinks \
  gcc-noemu \
  gcc-noemu-symlinks \
  g++-noemu \
  g++-noemu-symlinks \
"
