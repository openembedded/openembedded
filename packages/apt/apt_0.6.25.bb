require apt.inc
PR = "r3"

SRC_URI += "file://autofoo.patch;patch=1"

inherit autotools gettext

require apt-package.inc

FILES_${PN} += "${bindir}/apt-key"
apt-manpages += "doc/apt-key.8"
