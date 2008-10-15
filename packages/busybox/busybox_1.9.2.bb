require busybox.inc
PR = "r2"

SRC_URI = "http://www.busybox.net/downloads/busybox-${PV}.tar.gz \
           file://udhcpscript.patch;patch=1 \
           file://adduser-longops.patch;patch=1 \
           file://sort-z-nul.patch;patch=1;status=upstream \
           file://topmem.patch;patch=1 \
           file://busybox-cron \
           file://busybox-httpd \
           file://busybox-udhcpd \
           file://default.script \
           file://hwclock.sh \
           file://mount.busybox \
           file://syslog \
           file://syslog.conf \
           file://umount.busybox \
           file://defconfig"

EXTRA_OEMAKE += "V=1 ARCH=${TARGET_ARCH} CROSS_COMPILE=${TARGET_PREFIX}"

do_configure () {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
	cml1_do_configure
}
