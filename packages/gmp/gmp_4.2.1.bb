PR = "r2"

SRC_URI_append += "file://sh4-asmfix.patch;patch=1 \
                   file://x86-fat.diff;patch=1;pnum=0 "

require gmp.inc
