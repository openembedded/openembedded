require busybox.inc
PR = "${INC_PR}.1"

SRC_URI = "http://www.busybox.net/downloads/busybox-${PV}.tar.bz2;name=tarball \
           file://busybox-cron \
           file://busybox-httpd \
           file://busybox-udhcpd \
           file://default.script file://simple.script \
           file://hwclock.sh \
           file://mount.busybox \
           file://mountall \
           file://syslog \
           file://syslog.conf \
           file://udhcpscript.patch;patch=1 \
           file://busybox-appletlib-dependency.patch;patch=1 \
           file://umount.busybox \
           file://run_parts.c"
SRC_URI[tarball.md5sum] = "c91ec9756e2000073a9dd8fa9fc3f89e"
SRC_URI[tarball.sha256sum] = "83c4cc813124a43f13e2ebb83cea9da9909d63891b824bf4bc7006f0567db7cf"

SRC_URI += "http://busybox.net/downloads/fixes-1.7.2/busybox-1.7.2-ash.patch;patch=1;name=patch1 \
            http://busybox.net/downloads/fixes-1.7.2/busybox-1.7.2-iptun.patch;patch=1;name=patch2 \
            http://busybox.net/downloads/fixes-1.7.2/busybox-1.7.2-logger.patch;patch=1;name=patch3 \
            http://busybox.net/downloads/fixes-1.7.2/busybox-1.7.2-tail.patch;patch=1;name=patch4 \
            file://defconfig"

EXTRA_OEMAKE += "V=1 ARCH=${TARGET_ARCH} CROSS_COMPILE=${TARGET_PREFIX}"

do_configure () {
	cp ${WORKDIR}/run_parts.c ${S}/debianutils/
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
	cml1_do_configure
}

do_compile () {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	base_do_compile
}

do_install () {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	install -d ${D}${sysconfdir}/init.d
	oe_runmake "PREFIX=${D}" install
	cp -pPR ${S}/_install/* ${D}/

	# Move everything to /busybox (not supposed to end up in any package)
	install -d ${D}/busybox
	ls ${D} -R

	cp -dPr ${D}${base_bindir} ${D}${base_sbindir} ${D}${prefix} ${D}/busybox/
	# Move the busybox binary back to /bin
	install -d ${D}${base_bindir}
	mv ${D}/busybox${base_bindir}/busybox ${D}${base_bindir}/
	# Move back the sh symlink
	test -h ${D}/busybox${base_bindir}/sh && mv ${D}/busybox${base_bindir}/sh ${D}${base_bindir}/

	install -m 0755 ${WORKDIR}/syslog ${D}${sysconfdir}/init.d/
	install -m 644 ${WORKDIR}/syslog.conf ${D}${sysconfdir}/
	if grep "CONFIG_CROND=y" ${WORKDIR}/defconfig; then
		# Move crond back to /usr/sbin/crond
		install -d ${D}${sbindir}
		mv ${D}/busybox${sbindir}/crond ${D}${sbindir}/

		install -m 0755 ${WORKDIR}/busybox-cron ${D}${sysconfdir}/init.d/
	fi
	if grep "CONFIG_HTTPD=y" ${WORKDIR}/defconfig; then
		# Move httpd back to /usr/sbin/httpd
		install -d ${D}${sbindir}
		mv ${D}/busybox${sbindir}/httpd ${D}${sbindir}/

		install -m 0755 ${WORKDIR}/busybox-httpd ${D}${sysconfdir}/init.d/
		install -d ${D}/srv/www
	fi
	if grep "CONFIG_APP_UDHCPD=y" ${WORKDIR}/defconfig; then
		# Move udhcpd back to /usr/sbin/udhcpd
		install -d ${D}${sbindir}
		mv ${D}/busybox${sbindir}/udhcpd ${D}${sbindir}/

		install -m 0755 ${WORKDIR}/busybox-udhcpd ${D}${sysconfdir}/init.d/
	fi
	if grep "CONFIG_HWCLOCK=y" ${WORKDIR}/defconfig; then
		# Move hwclock back to /sbin/hwclock
		install -d ${D}${base_sbindir}
		mv ${D}/busybox${base_sbindir}/hwclock ${D}${base_sbindir}/

		install -m 0755 ${WORKDIR}/hwclock.sh ${D}${sysconfdir}/init.d/
	fi
	if grep "CONFIG_APP_UDHCPC=y" ${WORKDIR}/defconfig; then
		# Move dhcpc back to /usr/sbin/udhcpc
		install -d ${D}${base_sbindir}
		mv ${D}/busybox${base_sbindir}/udhcpc ${D}${base_sbindir}/

		install -d ${D}${sysconfdir}/udhcpc.d
		install -d ${D}${datadir}/udhcpc
		install -m 0755 ${S}/examples/udhcp/simple.script ${D}${sysconfdir}/udhcpc.d/50default
		install -m 0755 ${WORKDIR}/default.script ${D}${datadir}/udhcpc/default.script
	fi

	install -m 0644 ${S}/busybox.links ${D}${sysconfdir}
}

pkg_prerm_${PN} () {
	# This is so you can make busybox commit suicide - removing busybox with no other packages
	# providing its files, this will make update-alternatives work, but the update-rc.d part
	# for syslog, httpd and/or udhcpd will fail if there is no other package providing sh
	tmpdir=`mktemp -d /tmp/busyboxrm-XXXXXX`
	ln -s /bin/busybox $tmpdir/[
	ln -s /bin/busybox $tmpdir/test
	ln -s /bin/busybox $tmpdir/head
	ln -s /bin/busybox $tmpdir/sh
	ln -s /bin/busybox $tmpdir/basename
	ln -s /bin/busybox $tmpdir/echo
	ln -s /bin/busybox $tmpdir/mv
	ln -s /bin/busybox $tmpdir/ln
	ln -s /bin/busybox $tmpdir/dirname
	ln -s /bin/busybox $tmpdir/rm
	ln -s /bin/busybox $tmpdir/sed
	ln -s /bin/busybox $tmpdir/sort
	export PATH=$PATH:$tmpdir
	while read link; do case "$link" in /*/*/*) to="../../bin/busybox";; /bin/*) to="busybox";; /*/*) to="../bin/busybox";; esac; bn=`basename $link`; sh /usr/bin/update-alternatives --remove $bn $to; done </etc/busybox.links
}

SRC_URI[patch1.md5sum] = "4149857c0b2c7f3d52a1f2cec5d7778d"
SRC_URI[patch1.sha256sum] = "73706e7d77144a6270da02ede61cde3c2e3b0e716d879737ac9d478b29233ba9"
SRC_URI[patch2.md5sum] = "6c5f498e0677fd91b5b0e85ec5ac3b23"
SRC_URI[patch2.sha256sum] = "b80a8c173c7a7a40a504585c6af5c74396c8fdbbb1cec179de9edcc030aa6a9a"
SRC_URI[patch3.md5sum] = "43c292e93bf92623aaa29dd0e243e9a9"
SRC_URI[patch3.sha256sum] = "5117584a563c512b68cd9678d3cf54e6186f5a062836398791385f8ed73cca86"
SRC_URI[patch4.md5sum] = "c211189556c59a2665af45bffe5a5878"
SRC_URI[patch4.sha256sum] = "f44c3c2d7d9b3fc8a5f9fb6ac587ae4170d2515d72f9e76deb8c071ce9847abe"
