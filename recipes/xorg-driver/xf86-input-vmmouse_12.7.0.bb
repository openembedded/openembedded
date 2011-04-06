require xorg-driver-input.inc
DESCRIPTION = "X.Org X server -- VMMouse input driver to use with VMWare"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "dc77181330f983c7d0ec1ea1592c2ca7"
SRC_URI[archive.sha256sum] = "00e5d527a0d97e6b2a6e8c519e1339427e66fa0a43af026858655c7c62bd9e35"

COMPATIBLE_HOST = "i.86.*-linux"
