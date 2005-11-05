include apt.inc

PR = "r2"
SRC_URI += "file://autofoo.patch;patch=1"

inherit autotools gettext

include apt-package.inc

FILES_${PN} += "${bindir}/apt-key"
apt-manpages += "doc/apt-key.8"
