require busybox.inc
PR = "${INC_PR}.2"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_shr = "1"

SRC_URI = "\
  http://www.busybox.net/downloads/busybox-${PV}.tar.bz2;name=tarball \
  file://fdisk_nios2.patch \
  \
  file://udhcpscript.patch \
  file://udhcpc-fix-nfsroot.patch \
  file://B921600.patch \
  file://get_header_tar.patch \
  file://busybox-appletlib-dependency.patch \
#  file://0000-wget-no-check-certificate.patch \
  file://run-parts.in.usr-bin.patch \
  file://find-touchscreen.sh \
  file://busybox-cron \
  file://busybox-httpd \
  file://busybox-udhcpd \
  file://default.script file://simple.script \
  file://hwclock.sh \
  file://hwclock-default \
  file://mount.busybox \
  file://mountall \
  file://syslog \
  file://syslog.conf \
  file://umount.busybox \
  file://defconfig \
  file://mdev \
  file://mdev.conf \
"

SRC_URI[tarball.md5sum] = "2ba980f720a5bdce4ec05423519acc35"
SRC_URI[tarball.sha256sum] = "3bf1b1a41294d25335abdd10c65cffdb01c36337ca011f1b38c6ad89590115ba"

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

    if grep "CONFIG_UDHCPD=y" ${WORKDIR}/defconfig; then
          install -m 0755 ${WORKDIR}/busybox-udhcpd ${D}${sysconfdir}/init.d/
    fi

    if grep "CONFIG_UDHCPC=y" ${WORKDIR}/defconfig; then
          install -d ${D}${sysconfdir}/udhcpc.d
          install -d ${D}${datadir}/udhcpc
          install -m 0755 ${WORKDIR}/simple.script ${D}${sysconfdir}/udhcpc.d/50default
          install -m 0755 ${WORKDIR}/default.script ${D}${datadir}/udhcpc/default.script
    fi
}
