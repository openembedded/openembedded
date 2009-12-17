require coreutils.inc

SRC_URI = "\
  ftp://alpha.gnu.org/gnu/coreutils/coreutils-${PV}.tar.bz2 \
  file://futimens.patch;patch=1 \
  file://coreutils-install-use-STRIP.patch;patch=1 \
"
