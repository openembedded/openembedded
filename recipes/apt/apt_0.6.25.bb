require apt.inc
PR = "r3"

SRC_URI += "file://autofoo.patch;patch=1"

inherit autotools gettext

require apt-package.inc

FILES_${PN} += "${bindir}/apt-key"
apt-manpages += "doc/apt-key.8"

SRC_URI[md5sum] = "6569fd95e829036c141a5ccaf8e5948c"
SRC_URI[sha256sum] = "fa00ce910ab6f0987c4a210962be357d4f013fc89ef72b015f39ae8649522b59"
