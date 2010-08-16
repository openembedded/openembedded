require xorg-driver-input.inc
DESCRIPTION = "X.Org X server -- keyboard input driver"
DEPENDS += " kbproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "ebe5dcf8eed819103909f18321fc3b9d"
SRC_URI[archive.sha256sum] = "7b514715dfb5a2512dea3355bc3f09eb879d7184440c5525f0a9d29ec9f3be42"
