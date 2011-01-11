require xorg-app-common.inc
DESCRIPTION = "manual page browser for X"
DEPENDS += " libxaw libxprintutil libxp libxt"
RDEPENDS_${PN} = " man"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "5e5b3351bac26cc1f8490faf1c1402bb"
SRC_URI[archive.sha256sum] = "9d617ed760fe2147baae5ad9cbbdd85f1bb7534acfc3327bb51dad42e8bcc8b0"

FILES_${PN} += " /usr/share/X11/xman.help"
