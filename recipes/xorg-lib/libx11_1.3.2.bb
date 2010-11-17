require libx11.inc
PR = "${INC_PR}.3"
# gcc 4.5 ends up ICEing with thumb and -O1 with -fno-omit-framepointer
# therefore if we are in thumb mode then we use -Os instead of -O1 for
# DEBUG_OPTIMIZATION

DEBUG_OPTIMIZATION_thumb_append = " -Os"
SRC_URI += " file://dolt-fix.patch"
SRC_URI += " file://configure.ac-nios2.patch"
SRC_URI[archive.md5sum] = "001d780829f936e34851ef7cd37b4dfd"
SRC_URI[archive.sha256sum] = "4def4d5c9fce85d690f1f29d675154594acdea3d3fe792d0cb513732c7b4bcb2"
