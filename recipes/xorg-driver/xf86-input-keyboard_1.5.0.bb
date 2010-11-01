require xorg-driver-input.inc
DESCRIPTION = "X.Org X server -- keyboard input driver"
DEPENDS += " kbproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "b74d7162db5ce7899c17927c6cfa9522"
SRC_URI[archive.sha256sum] = "2303510e905465ebee91f22cdd75706a15afb108258bc220c7500f213de19cb0"
