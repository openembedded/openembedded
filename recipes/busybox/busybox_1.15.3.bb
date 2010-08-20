require busybox.inc
PR = "${INC_PR}.3"

SRC_URI = "\
  http://www.busybox.net/downloads/busybox-${PV}.tar.bz2;name=tarball \
  file://fdisk_nios2.patch \
  \
  file://udhcpscript.patch \
  file://udhcpc-fix-nfsroot.patch \
  file://B921600.patch \
  file://get_header_tar.patch \
  file://busybox-appletlib-dependency.patch \
  file://0000-wget-no-check-certificate.patch \
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
SRC_URI[tarball.md5sum] = "6059ac9456de6fb18dc8ee4cd0ec9240"
SRC_URI[tarball.sha256sum] = "d74020ad2cc5a4dcc5109c44dbd0e22582d6ce42954b0f1ff29763c8c0ff03cb"

# gcc 4.5 has this bug on thumb
# http://gcc.gnu.org/bugzilla/show_bug.cgi?id=44557
# so add -fomit-frame-pointer
# this will be removed once the above bug is fixed.


CFLAGS_append = " -fomit-frame-pointer"

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
