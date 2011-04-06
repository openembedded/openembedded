require xorg-driver-input.inc
DESCRIPTION = "X.Org X server -- keyboard input driver"
DEPENDS += " kbproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "e2abe9f13e526a73cb68a7d257546eba"
SRC_URI[archive.sha256sum] = "c46c790fec905d696573b7a374b10ab8b4389112a8f69993fe011006c99e858e"
