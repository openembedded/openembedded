require xorg-app-common.inc
DESCRIPTION = "Alter a monitor's gamma correction through the X server"
DEPENDS += " libxxf86vm"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "34d22b130bffd8aa857eae6d9da4bbb1"
SRC_URI[archive.sha256sum] = "7dc8334882a060bcc90042bceac5132dd87d5acc8d043b16311ef2134aea8e16"
