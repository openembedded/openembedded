require curl-common.inc
require curl-target.inc

SRC_URI += "file://off_t_abi_fix.patch;patch=1;pnum=0 \
            file://curl-add_all_algorithms.patch;patch=1"
PR = "r1"
