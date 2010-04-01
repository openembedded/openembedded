require glibmm.inc

DEPENDS += "mm-common"

SRC_URI += " file://remove-examples.patch;patch=1"

SRC_URI[archive.md5sum] = "58cec0c50bb079638265f3340565b421"
SRC_URI[archive.sha256sum] = "ff93ec4e3c9c54d91e5ecc1b5dde0acceeeeb0e03d6031db8587b27a2f83743f"

