require oprofile.inc

PR = "${INC_PR}.0"

SRC_URI += "\
           file://armv6_fix.patch;patch=1 \
           file://oparchive_fix.patch;patch=1 \
           file://root_option.patch;patch=1 \
           file://opstart.patch;patch=1 \
           file://fix-arith.patch;patch=1;pnum=0 \
           file://gcc43x-fix.patch;patch=1 \
           file://armv7a.diff;patch=1"

SRC_URI[tarball.md5sum] = "bb91e4d5bd45ff0d5c3e6214653422b7"
SRC_URI[tarball.sha256sum] = "4f86ab165dabcc7bc4008710a66fa0ed391c083e2a8bdf8a8f5bf11c0244b2cb"
