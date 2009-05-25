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
