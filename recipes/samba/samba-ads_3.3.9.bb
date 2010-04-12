require samba.inc
require samba-ads.inc
LICENSE = "GPLv3"

PR = "r3"
SRC_URI += "file://config-lfs.patch;patch=1 \
            file://quota.patch;patch=1;pnum=0 \
            file://configure-3.3.0.patch;patch=1 \
            file://config-h.patch;patch=1 \
            file://mtab.patch;patch=1 \
	        "

do_compile () {
        base_do_compile
}

SRC_URI[src.md5sum] = "d99c3ccc3066d1c6a0dba4de02aad24b"
SRC_URI[src.sha256sum] = "41a8919e3a32cf7523c49473edb478f3a7ec7d4ae4d125297a18d48f79e17f91"
