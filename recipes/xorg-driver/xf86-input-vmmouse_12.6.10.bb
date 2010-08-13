require xorg-driver-input.inc
DESCRIPTION = "X.Org X server -- VMMouse input driver to use with VMWare"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "49c6e77851e9f7bc5cb7d85f061992f8"
SRC_URI[archive.sha256sum] = "a6369d5a860627f2a38842d5563045b263a459e534f6ae08df48f330f9a40910"

COMPATIBLE_HOST = "i.86.*-linux"
