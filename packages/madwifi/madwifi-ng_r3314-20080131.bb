# Bitbake recipe for the madwifi-ng driver

# Disable stripping of kernel modules, since this action strips too
# much out, and the resulting module won't load.
INHIBIT_PACKAGE_STRIP = "1"

require madwifi-ng_r.inc

# PR set after the include, to override what's set in the included file.
PR = "r7"

SRC_URI += "http://sources.dreamboxupdate.com/download/snapshots/openwrt_madwifi_patches_20080811.tar.bz2 \
	file://40-fix-warnings.patch;patch=1;pnum=1 \
	http://sources.dreamboxupdate.com/download/snapshots/450-new_madwifi_mipsel_hal.patch.bz2;patch=1"

do_munge() {
	CUR=`pwd`
	cd ${S}
	for i in `ls ${WORKDIR}/openwrt_madwifi_patches | grep ".patch" | sort -n | xargs`; do
		oenote "Applying openwrt madwifi patch '$i'";
		patch -p1 < ${WORKDIR}/openwrt_madwifi_patches/$i;
	done;
	cd $CUR
}

addtask munge before do_patch after do_unpack


