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

SRC_URI[md5sum] = "bf6c09ea497a166df8bd672db1d8da8f"
SRC_URI[sha256sum] = "466410868375d19a286ac3fc5d9f3c267ce359189f8e0d76e72ec10bd54247da"
