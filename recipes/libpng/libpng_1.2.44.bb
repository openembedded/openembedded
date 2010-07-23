require libpng.inc

PR = "${INC_PR}.0"

SRC_URI += "file://makefile_fix.patch"

SRC_URI[libpng.md5sum] = "e3ac7879d62ad166a6f0c7441390d12b"
SRC_URI[libpng.sha256sum] = "b9ab20f1c2c3bf6c4448fd9bd8a4a8905b918114d5fada56c97bb758a17b7215"
