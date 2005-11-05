SECTION = "base"

PR = "r9"

DEPENDS = "nslu2-linksys-libs"

SRC_URI = "http://nslu.sf.net/downloads/nslu2-linksys-ramdisk-2.3r29.tar.bz2 \
	   file://README \
	   file://NOTES \
	   file://unsling \
	   file://resling \
	   file://slingover \
	   file://linuxrc \
	   file://nsswitch.conf \
	   file://rc.unslung-start \
	   file://rc.unslung-stop \
	   file://rc-diversion.patch;patch=1 \
	   file://rc.1-diversion.patch;patch=1 \
	   file://rc.crond-diversion.patch;patch=1 \
	   file://rc.halt-diversion.patch;patch=1 \
	   file://rc.local-diversion.patch;patch=1 \
	   file://rc.modules-diversion.patch;patch=1 \
	   file://rc.network-diversion.patch;patch=1 \
	   file://rc.quickset-diversion.patch;patch=1 \
	   file://rc.quota-diversion.patch;patch=1 \
	   file://rc.reboot-diversion.patch;patch=1 \
	   file://rc.reset_usrgrpshare-diversion.patch;patch=1 \
	   file://rc.rstimezone-diversion.patch;patch=1 \
	   file://rc.samba-diversion.patch;patch=1 \
	   file://rc.sysinit-diversion.patch;patch=1 \
	   file://rc.thttpd-diversion.patch;patch=1 \
	   file://rc.xinetd-diversion.patch;patch=1 \
	   file://root-passwd.patch;patch=1 \
	   file://tmp-handling.patch;patch=1 \
	   file://create-ramdisks.patch;patch=1 \
	   file://remount-noatime.patch;patch=1 \
	   file://initialise-mtab.patch;patch=1 \
	   file://wait-for-quotacheck.patch;patch=1 \
	   file://mount_usbdevfs.patch;patch=1 \
	   file://security-fixes.patch;patch=1 \
	   file://upgrade.htm file://upgrade.cgi \
	   file://rc.bootbin \
	   "

S = "${WORKDIR}/nslu2-linksys-ramdisk-2.3r29"

python () {
	# Don't build unslung images unless we're targeting an nslu2
	mach = bb.data.getVar("MACHINE", d, 1)
	dist = bb.data.getVar("DISTRO", d, 1)
	if mach != 'nslu2' or dist != 'unslung':
		raise bb.parse.SkipPackage("Unslung only builds for the Linksys NSLU2")
}

do_compile () {
	echo "V2.3R29-uNSLUng-${DISTRO_VERSION}" > ${S}/.unslung

	sed -i -e s/@version#/@version#-uNSLUng-${DISTRO_VERSION}/ ${S}/home/httpd/html/home.htm
	sed -i -e 's|>&nbsp;<|><a href="Unslung" class="mainmenu" target="_top">Unslung Doco</a><|' \
		${S}/home/httpd/html/manhead.htm

	install -m 755 ${WORKDIR}/linuxrc ${S}/linuxrc

	# Allow rc.bootbin to be diverted.
	mv ${S}/etc/rc.d/rc.bootbin ${S}/sbin/rc.bootbin
	install -m 755 ${WORKDIR}/rc.bootbin ${S}/etc/rc.d/rc.bootbin

	install -d ${S}/initrd

	install -m 755 ${WORKDIR}/unsling ${S}/sbin/unsling
	install -m 755 ${WORKDIR}/resling ${S}/sbin/resling
	install -m 755 ${WORKDIR}/slingover ${S}/sbin/slingover
	install -m 755 ${WORKDIR}/rc.unslung-start ${S}/etc/rc.d/rc.unslung-start
	install -m 755 ${WORKDIR}/rc.unslung-stop ${S}/etc/rc.d/rc.unslung-stop

	install -m 644 ${WORKDIR}/nsswitch.conf ${S}/etc/nsswitch.conf

	install -d ${S}/opt/doc
	install -m 755 ${WORKDIR}/README ${S}/opt/doc/README
	install -m 755 ${WORKDIR}/NOTES ${S}/opt/doc/NOTES
	ln -s /opt/doc ${S}/home/httpd/html/Unslung

	# Add the diversion script directory
	install -d ${S}/unslung

	# Remove the libraries, because they are in nslu2-linksys-libs now
	rm -rf ${S}/lib

	# Install upgrade mode files
	mv ${S}/home/httpd/html/Management/upgrade.htm ${S}/home/httpd/html/Management/upgrade-old.htm 
	mv ${S}/home/httpd/html/Management/upgrade.cgi ${S}/home/httpd/html/Management/upgrade-old.cgi 
	install -m 644 ${WORKDIR}/upgrade.htm ${S}/home/httpd/html/Management
	install -m 755 ${WORKDIR}/upgrade.cgi ${S}/home/httpd/html/Management
	sed -i -e s/@ds_sw_version#/@ds_sw_version#-uNSLUng-${DISTRO_VERSION}/ \
		${S}/home/httpd/html/Management/upgrade.htm
}

do_install () {
	( cd ${S} ; tar -c -v -f - --exclude '.pc' . ) | ( cd ${D} ; tar xvf - )
}

PACKAGES = "${PN}"
FILES_${PN} = "/"
RDEPENDS_${PN} = "nslu2-linksys-libs"
