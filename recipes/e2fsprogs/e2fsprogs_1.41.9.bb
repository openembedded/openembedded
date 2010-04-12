require e2fsprogs.inc

PR = "${INC_PR}"

do_configure() {
        oe_runconf
}

SRC_URI[md5sum] = "52f60a9e19a02f142f5546f1b5681927"
SRC_URI[sha256sum] = "cbf1e34261a16b3d7911b60b91290b19f2010036d6ba628d45b5f0b2af2b66e8"
