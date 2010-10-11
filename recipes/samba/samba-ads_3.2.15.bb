require samba.inc
require samba-ads.inc
LICENSE = "GPLv3"

PR = "r2"
SRC_URI += "file://config-lfs.patch \
            file://quota.patch;striplevel=0 \
            file://configure-3.2.8.patch \
            file://config-h.patch \
            file://mtab.patch \
	        "
SRC_URI[md5sum] = "5a3bcc4927c9643b9f42970d0815b18f"
SRC_URI[sha256sum] = "84281fd1faeffee8558e49dff865dd382abbf78bc1be00f8cb5aa70aeea67d46"
