require busybox.inc
PR = "${INC_PR}"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "\
  http://www.busybox.net/downloads/busybox-${PV}.tar.bz2 \
  file://fdisk_nios2.patch \
  \
  file://udhcpscript.patch \
  file://udhcpc-fix-nfsroot.patch \
  file://B921600.patch \
  file://get_header_tar.patch \
  file://busybox-appletlib-dependency.patch \
#  file://0000-wget-no-check-certificate.patch \
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

SRC_URI[md5sum] = "c7fe7533b7fc4018b0b49a05ee0ee601"
SRC_URI[sha256sum] = "bf9177810d7e151b0e662477c33b9afd062570e6298ec46f2a8397a6a839d164"

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
