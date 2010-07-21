require coreutils.inc

LICENSE = GPLv2

SRC_URI = "\
  ftp://alpha.gnu.org/gnu/coreutils/coreutils-${PV}.tar.bz2 \
  file://futimens.patch \
  file://coreutils-install-use-STRIP.patch \
"
