require emacs.inc

EXTRA_OECONF = "--without-sound --without-x"

#/!\warning untested recipe
DEFAULT_PREFERENCE = "-2" 


FILESPATH = "${FILE_DIRNAME}/emacs-${PV}:${FILE_DIRNAME}/files"
SRC_URI = "${GNU_MIRROR}/emacs/emacs-${PV}.tar.gz;name=tarball \
	   file://emacs23.1-use-qemu.patch;patch=1 \
	   file://nostdlib-unwind.patch;patch=1"
SRC_URI[tarball.md5sum] = "a620d4452769d04ad8864d662f34f8dd"
SRC_URI[tarball.sha256sum] = "a94cd46301f000d2d1dcd3fd7ef08ad952846d01ca5d4168b4ec3e38e857da47"


S = "${WORKDIR}/emacs-${PV}"
