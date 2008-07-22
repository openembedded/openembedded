require busybox.inc
PR = "r1"

SRC_URI = "\
  http://www.busybox.net/downloads/busybox-${PV}.tar.gz \
  http://busybox.net/downloads/fixes-1.11.1/busybox-1.11.1-basename.patch;patch=1 \
  http://busybox.net/downloads/fixes-1.11.1/busybox-1.11.1-tar.patch;patch=1 \
  \
  file://udhcpscript.patch;patch=1 \
  file://busybox-cron \
  file://busybox-httpd \
  file://busybox-udhcpd \
  file://default.script \
  file://hwclock.sh \
  file://mount.busybox \
  file://syslog \
  file://syslog.conf \
  file://umount.busybox \
  file://defconfig \
"

EXTRA_OEMAKE += "V=1 ARCH=${TARGET_ARCH} CROSS_COMPILE=${TARGET_PREFIX}"

do_configure () {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
	cml1_do_configure
}
