require glibc_${PV}.bb
require glibc-initial.inc

do_configure_prepend () {
	unset CFLAGS
}

SRC_URI[md5sum] = "11cf6d3fc86dbe0890b8d00372eb6286"
SRC_URI[sha256sum] = "3ded3a3c3ba2cf02d72479a5cc0829c7c261a9d0934e49a79233de9fa276ec22"
SRC_URI[md5sum] = "53d88ca624642dd267752ccce77b19d0"
SRC_URI[sha256sum] = "d094028bc6d6691f56b4efeff7cd7e1c7ca10733e0cb5efc36e8fb08d8324bf1"
SRC_URI[md5sum] = "503f1315afd808728ebaa75b3d87a7d9"
SRC_URI[sha256sum] = "67c98ca1299f5f25eaece256d033e0e63bcf6876b920ca62a1fe61ac62c5c451"
