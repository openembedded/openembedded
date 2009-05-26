require emacs.inc

PR="r1"

EXTRA_OECONF = "--without-sound --without-x"

SRC_URI = "${GNU_MIRROR}/emacs/emacs-${PV}.tar.gz \
	   file://use-qemu.patch;patch=1 \
	   file://nostdlib-unwind.patch;patch=1"

S = "${WORKDIR}/emacs-${PV}"
