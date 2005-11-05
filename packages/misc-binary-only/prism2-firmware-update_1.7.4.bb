DESCRIPTION = "one-time install package to upgrade the firmware of all installed prism2 based cards."
RDEPENDS = "hostap-modules-pci hostap-utils"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"
LICENSE = "unknown"

SRC_URI = "http://www.red-bean.com/~proski/firmware/${PV}.tar.bz2"

INHIBIT_PACKAGE_STRIP = "1"

do_install() {
	install -d ${D}tmp
	install ${WORKDIR}/${PV}/pk010101.hex ${D}tmp
	install ${WORKDIR}/${PV}/sf010704.hex ${D}tmp
}

pkg_postinst() {
if test "x$D" != "x"; then
	exit 1
else
	FW_VERSION="v${PV}";
	
	fw_upgrade() {
		IF=$1;
		echo "firmware upgrade on $IF"
		if [ ! `iwconfig $IF | grep "No such device"` ]; then
			echo -n "  - current firmware version: ";
			echo `hostap_diag $IF | grep STAID | awk '{print $3}'`;
			if [[ `hostap_diag $IF | grep STAID | awk '{print $3}'` < $FW_VERSION ]]; then
				echo "  - upgrading to version $FW_VERSION"
				prism2_srec -f $IF /tmp/sf010704.hex /tmp/pk010101.hex
			else 
				echo "  - upgrade not necessary"
			fi
		fi
		echo "done".
	}
	
	for i in `ls /proc/net/hostap`; do
		fw_upgrade $i;
	done;
fi
}

FILES_${PN} += "/tmp"
