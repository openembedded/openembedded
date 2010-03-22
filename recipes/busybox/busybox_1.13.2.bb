require busybox.inc
PR = "${INC_PR}.1"

SRC_URI = "\
  http://www.busybox.net/downloads/busybox-${PV}.tar.bz2;name=tarball \
  file://busybox-1.13.2-awk.patch;patch=1 \
  file://busybox-1.13.2-depmod.patch;patch=1 \
  file://busybox-1.13.2-init.patch;patch=1 \
  file://busybox-1.13.2-killall.patch;patch=1 \
  file://busybox-1.13.2-mdev.patch;patch=1 \
  file://busybox-1.13.2-modprobe.patch;patch=1 \
  file://busybox-1.13.2-printf.patch;patch=1 \
  file://busybox-1.13.2-syslogd.patch;patch=1 \
  file://busybox-1.13.2-tar.patch;patch=1 \
  file://busybox-1.13.2-top24.patch;patch=1 \
  file://busybox-1.13.2-unzip.patch;patch=1 \
  file://busybox-1.13.2-wget.patch;patch=1 \
  \
  file://udhcpscript.patch;patch=1 \
  file://udhcpc-fix-nfsroot.patch;patch=1 \
  file://B921600.patch;patch=1 \
  file://get_header_tar.patch;patch=1 \
  file://busybox-appletlib-dependency.patch;patch=1 \
  file://find-touchscreen.sh \
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
SRC_URI[tarball.md5sum] = "9e2a604d18bef219a5a6bf3acf78b9e1"
SRC_URI[tarball.sha256sum] = "927774408bd982dd246fb716bb2e646ab0708ce321b42c5e271dc98c1f5d1dc8"

EXTRA_OEMAKE += "V=1 ARCH=${TARGET_ARCH} CROSS_COMPILE=${TARGET_PREFIX}"

do_configure_prepend () {
	if [ "${TARGET_ARCH}" = "avr32" ] ; then
		sed -i s:CONFIG_FEATURE_OSF_LABEL=y:CONFIG_FEATURE_OSF_LABEL=n: ${WORKDIR}/defconfig
	fi
}

do_install_append() {
    install -m 0644 ${WORKDIR}/mdev.conf ${D}${sysconfdir}/
    install -d ${D}${sysconfdir}/init.d/
    install -d ${D}${sysconfdir}/mdev
    install -m 0755 ${WORKDIR}/find-touchscreen.sh ${D}${sysconfdir}/mdev/
    install -m 0755 ${WORKDIR}/mdev ${D}${sysconfdir}/init.d/
}
