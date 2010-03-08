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
