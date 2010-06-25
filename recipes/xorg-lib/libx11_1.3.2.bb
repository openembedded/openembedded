require libx11.inc
PR = "${INC_PR}.0"

SRC_URI += " file://dolt-fix.patch"
SRC_URI[archive.md5sum] = "001d780829f936e34851ef7cd37b4dfd"
SRC_URI[archive.sha256sum] = "4def4d5c9fce85d690f1f29d675154594acdea3d3fe792d0cb513732c7b4bcb2"
