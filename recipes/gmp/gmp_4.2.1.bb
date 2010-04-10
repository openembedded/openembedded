PR = "r2"

SRC_URI_append += "file://sh4-asmfix.patch;patch=1 \
                   file://x86-fat.diff;patch=1;pnum=0 "

require gmp.inc

SRC_URI[gmp.md5sum] = "091c56e0e1cca6b09b17b69d47ef18e3"
SRC_URI[gmp.sha256sum] = "d07ffcb37eecec35c5ec72516d10b35fdf6e6fef1fcf1dcd37e30b8cbf8bf941"
