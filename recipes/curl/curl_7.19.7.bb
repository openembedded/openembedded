require curl-common.inc
require curl-target.inc

SRC_URI += "file://off_t_abi_fix.patch;patch=1;pnum=0"
PR = "${INC_PR}"

SRC_URI[tarball.md5sum] = "79a8fbb2eed5464b97bdf94bee109380"
SRC_URI[tarball.sha256sum] = "1a15f94ae3401e3bd6208ce64155c2577815019824bceae7fd3221a12bc54a70"
