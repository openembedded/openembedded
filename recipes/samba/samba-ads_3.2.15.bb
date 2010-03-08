require samba.inc
require samba-ads.inc
LICENSE = "GPLv3"

PR = "r2"
SRC_URI += "file://config-lfs.patch;patch=1 \
            file://quota.patch;patch=1;pnum=0 \
            file://configure-3.2.8.patch;patch=1 \
            file://config-h.patch;patch=1 \
            file://mtab.patch;patch=1 \
	        "
SRC_URI[src.md5sum] = "5a3bcc4927c9643b9f42970d0815b18f"
SRC_URI[src.sha256sum] = "84281fd1faeffee8558e49dff865dd382abbf78bc1be00f8cb5aa70aeea67d46"
