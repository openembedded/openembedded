# Bitbake recipe for the madwifi-ng driver

# Disable stripping of kernel modules, since this action strips too
# much out, and the resulting module won't load.
INHIBIT_PACKAGE_STRIP = "1"

require madwifi-ng_r.inc

# PR set after the include, to override what's set in the included file.
PR = "r8"

SRC_URI += "http://sources.dreamboxupdate.com/download/snapshots/openwrt_madwifi_patches_20080829.tar.bz2 \
	http://sources.dreamboxupdate.com/download/snapshots/ath_hal-20080815.tgz \
	file://40-fix-warnings.patch;patch=1;pnum=1"

do_munge() {
	rm -rf ${S}/hal || /bin/true
	mv ${WORKDIR}/ath_hal-20080815 ${S}/hal
	CUR=`pwd`
	cd ${S}
	for i in `ls ${WORKDIR}/openwrt_madwifi_patches | grep ".patch" | sort -n | xargs`; do
		oenote "Applying openwrt madwifi patch '$i'";
		patch -p1 < ${WORKDIR}/openwrt_madwifi_patches/$i;
	done;
	cd $CUR
}

addtask munge before do_compile after do_patch


