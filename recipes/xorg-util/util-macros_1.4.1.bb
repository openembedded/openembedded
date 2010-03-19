require util-macros.inc
SRC_URI += " file://malloc_zero_returns_null.patch;patch=1"
PR = "${INC_PR}.0"
SRC_URI[archive.md5sum] = "8ac38951e753f250aaefbd4ba0afda94"
SRC_URI[archive.sha256sum] = "d49ab68cad724ae51f6cb69f7f5cfff7629cbb066f4c5c8bda81d62675a21986"
