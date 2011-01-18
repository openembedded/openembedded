# Available IMAGE_FEATURES:
# - apps-console-core
# - x11-base            - X11 server + minimal desktop
# - x11-sato            - OpenedHand Sato environment
# - dev-pkgs            - development packages
# - dbg-pkgs            - debug packages

DISTRO_TASKS += '\
    ${@base_contains("IMAGE_FEATURES", "apps-console-core", "task-poky-apps-console", "",d)} \
    ${@base_contains("IMAGE_FEATURES", ["apps-console-core", "dbg-pkgs"], "task-poky-apps-console-dbg", "",d)} \
    ${@base_contains("IMAGE_FEATURES", ["apps-console-core", "dev-pkgs"], "task-poky-apps-console-dev", "",d)} \
    \
    ${@base_contains("IMAGE_FEATURES", "x11-base", "task-poky-x11-base", "",d)} \
    ${@base_contains("IMAGE_FEATURES", ["x11-base", "dbg-pkgs"], "task-poky-x11-base-dbg", "",d)} \
    ${@base_contains("IMAGE_FEATURES", ["x11-base", "dev-pkgs"], "task-poky-x11-base-dev", "",d)} \
    \
    ${@base_contains("IMAGE_FEATURES", "x11-sato", "task-poky-x11-sato", "",d)} \
    ${@base_contains("IMAGE_FEATURES", ["x11-sato", "dbg-pkgs"], "task-poky-x11-sato-dbg", "",d)} \
    ${@base_contains("IMAGE_FEATURES", ["x11-sato", "dev-pkgs"], "task-poky-x11-sato-dev", "",d)} \
    '

IMAGE_INSTALL ?= "${DISTRO_TASKS}"

X11_IMAGE_FEATURES  = "x11-base"
SATO_IMAGE_FEATURES = "${X11_IMAGE_FEATURES} apps-x11-sato"

inherit image

ROOTFS_POSTPROCESS_COMMAND += "rootfs_update_buildinfo"

rootfs_update_buildinfo () {
	echo "BUG Linux Build Information"	> ${IMAGE_ROOTFS}/etc/buildinfo
	echo "Version:    2.1.0"		>> ${IMAGE_ROOTFS}/etc/buildinfo
	echo "Build Host: `uname -a`"		>> ${IMAGE_ROOTFS}/etc/buildinfo
	echo "Build User: `whoami`"		>> ${IMAGE_ROOTFS}/etc/buildinfo
	echo "Build Time: `date -u`"		>> ${IMAGE_ROOTFS}/etc/buildinfo
	echo "Revision:  ${METADATA_REVISION}"	>> ${IMAGE_ROOTFS}/etc/buildinfo

	# Alias stuff that normally should belong into the bashrc or similar
	echo "alias ipkg='opkg'" >>${IMAGE_ROOTFS}/etc/profile
	echo "alias ll='ls -al'" >>${IMAGE_ROOTFS}/etc/profile

	# Bandaid for RI1413
	echo "vm.min_free_kbytes = 4096" >> ${IMAGE_ROOTFS}/etc/sysctl.conf

	# We don't want persistent net rules as we would like to be able using
	# the same rootfs in other bugs.
	rm ${IMAGE_ROOTFS}/lib/udev/write_net_rules

	curdir=$PWD
	cd ${IMAGE_ROOTFS}/usr/lib/
	ln -sf libbluetooth.so.3 libbluetooth.so
	cd $curdir
}
