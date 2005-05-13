DESCRIPTION = "BusyBox combines tiny versions of many common UNIX utilities into a single \
small executable. It provides minimalist replacements for most of the \
utilities you usually find in GNU fileutils, shellutils, etc. The utilities \
in BusyBox generally have fewer options than their full-featured GNU \
cousins; however, the options that are included provide the expected \
functionality and behave very much like their GNU counterparts. BusyBox \
provides a fairly complete POSIX environment for any small or embedded \
system."
HOMEPAGE = "http://www.busybox.net"
LICENSE = "GPL"
SECTION = "base"
PRIORITY = "required"
PR = "r19"

SRC_URI = "http://www.busybox.net/downloads/busybox-${PV}.tar.gz \
           file://add-getkey-applet.patch;patch=1 \
	   file://udhcpscript.patch;patch=1 \
	   file://dhcpretrytime.patch;patch=1 \
	   file://hdparm_M.patch;patch=1 \
	   file://udhcppidfile.patch;patch=1 \
	   file://udhcppidfile-breakage.patch;patch=1 \
	   file://readlink.patch;patch=1 \
	   file://iproute-flush-cache.patch;patch=1;pnum=0 \
	   file://rmmod.patch;patch=1 \
	   file://below.patch;patch=1 \
	   file://fbset.patch;patch=1 \
	   file://mount-all-type.patch;patch=1 \
           file://defconfig \
           file://busybox-cron \
	   file://busybox-httpd \
	   file://busybox-udhcpd \
	   file://syslog \
           file://hwclock.sh \
	   file://default.script \
	   file://syslog.conf \
	   file://mount.busybox \
	   file://umount.busybox"

S = "${WORKDIR}/busybox-${PV}"

export EXTRA_CFLAGS = "${CFLAGS}"
EXTRA_OEMAKE_append = " CROSS=${HOST_PREFIX}"
FILES_${PN} += " ${datadir}/udhcpc"

inherit cml1 update-rc.d

INITSCRIPT_NAME = "syslog"
INITSCRIPT_PARAMS = "defaults"

do_configure () {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
	cml1_do_configure
}

do_compile () {
	unset CFLAGS
	base_do_compile
}

do_install () {
	install -d ${D}${sysconfdir}/init.d
	oe_runmake 'PREFIX=${D}' install
	install -m 0755 ${WORKDIR}/syslog ${D}${sysconfdir}/init.d/
	install -m 644 ${WORKDIR}/syslog.conf ${D}${sysconfdir}/
	if grep "CONFIG_CROND=y" ${WORKDIR}/defconfig; then 
		install -m 0755 ${WORKDIR}/busybox-cron ${D}${sysconfdir}/init.d/
	fi
	if grep "CONFIG_HTTPD=y" ${WORKDIR}/defconfig; then 
		install -m 0755 ${WORKDIR}/busybox-httpd ${D}${sysconfdir}/init.d/
	fi
	if grep "CONFIG_UDHCPD=y" ${WORKDIR}/defconfig; then 
		install -m 0755 ${WORKDIR}/busybox-udhcpd ${D}${sysconfdir}/init.d/
	fi
	if grep "CONFIG_HWCLOCK=y" ${WORKDIR}/defconfig; then 
		install -m 0755 ${WORKDIR}/hwclock.sh ${D}${sysconfdir}/init.d/
	fi
	if grep "CONFIG_UDHCPC=y" ${WORKDIR}/defconfig; then 
		install -d ${D}${sysconfdir}/udhcpc.d
		install -d ${D}${datadir}/udhcpc
		install -m 0755 ${S}/examples/udhcp/simple.script ${D}${sysconfdir}/udhcpc.d/50default
		install -m 0755 ${WORKDIR}/default.script ${D}${datadir}/udhcpc/default.script
	fi
	rm ${D}${base_bindir}/mount
	install -m 0755 ${WORKDIR}/mount.busybox ${D}${base_bindir}/
	rm ${D}${base_bindir}/umount
	install -m 0755 ${WORKDIR}/umount.busybox ${D}${base_bindir}/
}

pkg_postinst () {
	update-alternatives --install /bin/mount mount /bin/mount.busybox 50
	update-alternatives --install /bin/umount umount /bin/umount.busybox 50
}

pkg_prerm () {
	update-alternatives --remove mount /bin/mount.busybox
	update-alternatives --remove umount /bin/umount.busybox
}
