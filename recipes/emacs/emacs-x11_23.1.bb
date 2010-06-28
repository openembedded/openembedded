require emacs.inc

# full X (non-diet) is needed for X support
DEPENDS += "gtk+ libungif dbus"

PR = "r3"

EXTRA_OECONF = "--without-sound --with-x-toolkit=gtk"

DEFAULT_PREFERENCE = "-1"

RREPLACES_${PN} = "emacs"

FILESPATHPKG =. "emacs-${PV}:"
SRC_URI = "${GNU_MIRROR}/emacs/emacs-${PV}.tar.gz;name=tarball \
           file://emacs23.1-use-qemu.patch \
           file://nostdlib-unwind.patch \
           file://configure.in.lost.backslashes.patch"
SRC_URI[tarball.md5sum] = "a620d4452769d04ad8864d662f34f8dd"
SRC_URI[tarball.sha256sum] = "a94cd46301f000d2d1dcd3fd7ef08ad952846d01ca5d4168b4ec3e38e857da47"


S = "${WORKDIR}/emacs-${PV}"
