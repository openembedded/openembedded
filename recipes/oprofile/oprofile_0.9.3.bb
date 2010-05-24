require oprofile.inc

PR = "${INC_PR}.0"

SRC_URI += "\
           file://armv6_fix.patch;apply=yes \
           file://oparchive_fix.patch;apply=yes \
           file://root_option.patch;apply=yes \
           file://opstart.patch;apply=yes \
           file://fix-arith.patch;apply=yes;striplevel=0 \
           file://gcc43x-fix.patch;apply=yes \
           file://armv7a.diff;apply=yes"

SRC_URI[tarball.md5sum] = "bb91e4d5bd45ff0d5c3e6214653422b7"
SRC_URI[tarball.sha256sum] = "4f86ab165dabcc7bc4008710a66fa0ed391c083e2a8bdf8a8f5bf11c0244b2cb"
