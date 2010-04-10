require curl-common.inc
require curl-target.inc

SRC_URI += "file://off_t_abi_fix.patch;patch=1;pnum=0 \
            file://curl-add_all_algorithms.patch;patch=1 \
            file://curl-7.19.5-CVE-2009-2417.patch;patch=1;pnum=0"

PR = "${INC_PR}.2"

SRC_URI[tarball.md5sum] = "426d161661dce70c8ea9ad8f553363a3"
SRC_URI[tarball.sha256sum] = "05ad84a9c8d340917370f357ad9fdce5ea595deb11f4cb70f946fa48c7b02cd0"
