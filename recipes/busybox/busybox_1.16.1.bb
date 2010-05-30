require busybox.inc
PR = "${INC_PR}.0"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "\
  http://www.busybox.net/downloads/busybox-${PV}.tar.bz2;name=tarball \
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
  file://mount.busybox \
  file://mountall \
  file://syslog \
  file://syslog.conf \
  file://umount.busybox \
  file://defconfig \
  file://mdev \
  file://mdev.conf \
"

SRC_URI[tarball.md5sum] = "319486ec65078d07fde26eb620fecde7"
SRC_URI[tarball.sha256sum] = "6d45ec8e72ca85516c8669f81267e0fbe11881435983e32532a56b44651dd6c5"

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
