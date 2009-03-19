require emacs.inc

# full X (non-diet) is needed for X support
DEPENDS += "gtk+ libungif"

EXTRA_OECONF = "--without-sound --with-x-toolkit=gtk"

RREPLACES = "emacs"

FILESPATH = "${FILE_DIRNAME}/emacs-${PV}:${FILE_DIRNAME}/files"
SRC_URI = "${GNU_MIRROR}/emacs/emacs-${PV}.tar.gz \
	   file://use-qemu.patch;patch=1 \
	   file://nostdlib-unwind.patch;patch=1"

S = "${WORKDIR}/emacs-${PV}"
