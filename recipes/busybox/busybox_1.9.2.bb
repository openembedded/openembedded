require busybox.inc
PR = "${INC_PR}.1"

SRC_URI = "http://www.busybox.net/downloads/busybox-${PV}.tar.bz2;name=tarball \
           file://udhcpscript.patch;patch=1 \
           file://adduser-longops.patch;patch=1 \
           file://sort-z-nul.patch;patch=1;status=upstream \
           file://topmem.patch;patch=1 \
           file://busybox-appletlib-dependency.patch;patch=1 \
           file://busybox-cron \
           file://busybox-httpd \
           file://busybox-udhcpd \
           file://default.script file://simple.script \
           file://hwclock.sh \
           file://mount.busybox \
           file://mountall \
           file://syslog \
           file://syslog.conf \
           file://umount.busybox \
           file://defconfig"
SRC_URI[tarball.md5sum] = "7e26c56012dd5811251c2f87786b9a77"
SRC_URI[tarball.sha256sum] = "a14ca1104242953672807f5b5223de5615c237a27140f36d625b3067daaf11dc"

EXTRA_OEMAKE += "V=1 ARCH=${TARGET_ARCH} CROSS_COMPILE=${TARGET_PREFIX}"

do_configure () {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
	cml1_do_configure
}
