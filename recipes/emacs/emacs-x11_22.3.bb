require emacs.inc

# full X (non-diet) is needed for X support
DEPENDS += "gtk+ libungif"

EXTRA_OECONF = "--without-sound --with-x-toolkit=gtk"

RREPLACES_${PN} = "emacs"

FILESPATHPKG =. "emacs-${PV}:"
SRC_URI = "${GNU_MIRROR}/emacs/emacs-${PV}.tar.gz \
	   file://use-qemu.patch \
	   file://nostdlib-unwind.patch"

S = "${WORKDIR}/emacs-${PV}"

SRC_URI[md5sum] = "aa8ba34f548cd78b35914ae5a7bb87eb"
SRC_URI[sha256sum] = "7bd9b719db8ee20c75ee0d256737f7fd2c0e2ea30a285a3afbfc32c856420d16"
