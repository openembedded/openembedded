require coreutils.inc

SRC_URI = "\
  ftp://alpha.gnu.org/gnu/coreutils/coreutils-${PV}.tar.bz2 \
  file://futimens.patch;apply=yes \
  file://coreutils-install-use-STRIP.patch;apply=yes \
"
