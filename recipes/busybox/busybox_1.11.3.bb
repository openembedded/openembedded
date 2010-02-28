require busybox.inc
PR = "${INC_PR}.1"

SRC_URI = "\
  http://www.busybox.net/downloads/busybox-${PV}.tar.bz2;name=tarball \
  \
  file://udhcpscript.patch;patch=1 \
  file://B921600.patch;patch=1 \
  file://fdisk_lineedit_segfault.patch;patch=1 \
  file://iptunnel.patch;patch=1 \
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
  file://defconfig \
  file://mdev \
  file://mdev.conf \
"
SRC_URI[tarball.md5sum] = "4355ad8bb57ce3b39ad827566c1a6da3"
SRC_URI[tarball.sha256sum] = "6d35fda668988c06f8c22e6e20fe6951ec83108169df6b8c0bad99872577c784"

EXTRA_OEMAKE += "V=1 ARCH=${TARGET_ARCH} CROSS_COMPILE=${TARGET_PREFIX}"

do_install_append() {
    install -m 0644 ${WORKDIR}/mdev.conf ${D}${sysconfdir}/
    install -d ${D}${sysconfdir}/init.d/
    install -m 0755 ${WORKDIR}/mdev ${D}${sysconfdir}/init.d/
}

