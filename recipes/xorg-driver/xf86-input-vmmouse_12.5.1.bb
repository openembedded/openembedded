require xorg-driver-input.inc
DESCRIPTION = "X.Org X server -- VMMouse input driver to use with VMWare"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "1e2feafb8e4f1b670aeb39bcac9fbb18"
SRC_URI[archive.sha256sum] = "63608ba07138f01eadb9a02d8054c306501d907dd706ae61fdc030c50a7bfcfb"

COMPATIBLE_HOST = "i.86.*-linux"
