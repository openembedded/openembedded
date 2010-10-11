require samba.inc
require samba-ads.inc
LICENSE = "GPLv3"

PR = "r3"
SRC_URI += "file://config-lfs.patch \
            file://quota.patch;striplevel=0 \
            file://configure-3.3.0.patch \
            file://config-h.patch \
            file://mtab.patch \
	        "

do_compile () {
        base_do_compile
}

SRC_URI[md5sum] = "d99c3ccc3066d1c6a0dba4de02aad24b"
SRC_URI[sha256sum] = "41a8919e3a32cf7523c49473edb478f3a7ec7d4ae4d125297a18d48f79e17f91"
