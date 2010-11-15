require xorg-driver-input.inc
DESCRIPTION = "X.Org X server -- ELOGraphics input driver"
PE = "2"
PR = "${INC_PR}.1"

SRC_URI += "file://elo-adjustable-screen-size.patch"

SRC_URI[archive.md5sum] = "c4dbc216b2ddfcec93ae74ca00fae95a"
SRC_URI[archive.sha256sum] = "dfede47c14c40e51294c84bf8f9bec5f5e0b17c80f370ae2ac6bddad79f9e66b"
