SECTION = "base"

PR = "r13"

DEPENDS = "nslu2-linksys-libs nslu2-linksys-sambacodepages"

SRC_URI = "http://nslu.sf.net/downloads/nslu2-linksys-ramdisk-2.3r63-2.tar.bz2 \
	   file://README \
	   file://NOTES \
	   file://ipkg-fl \
	   file://motd-fl \
	   file://motd-un \
	   file://unsling \
	   file://resling \
	   file://slingover \
	   file://linuxrc \
	   file://unslung.gif \
	   file://nsswitch.conf \
	   file://rc.optware-start \
	   file://rc.optware-stop \
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
	   file://rc.samba-syntaxfix.patch;patch=1 \
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
	   file://rc.sysinit-clean_var.patch;patch=1 \
	   file://rc.sysinit-cpbug.patch;patch=1 \
	   file://rc.modules-nls.patch;patch=1 \
	   file://telnet-passwd.patch;patch=1 \
	   file://upgrade.htm \
	   file://telnet.htm \
	   file://rc.bootbin \
	   "

S = "${WORKDIR}/nslu2-linksys-ramdisk-2.3r63"

python () {
	# Don't build unslung images unless we're targeting an nslu2
	mach = bb.data.getVar("MACHINE", d, 1)
	if mach != 'nslu2':
		raise bb.parse.SkipPackage("Unslung only builds for the Linksys NSLU2")
}

do_compile () {
	echo "V2.3R63-uNSLUng-${DISTRO_VERSION}" > ${S}/.unslung

	install -m 644 ${WORKDIR}/unslung.gif ${S}/home/httpd/html/linksys.gif

	install -m 644 ${WORKDIR}/telnet.htm ${S}/home/httpd/html/Management/telnet.htm

	sed -i -e 's/@version#</@version#-uNSLUng-'${DISTRO_VERSION}'</' ${S}/home/httpd/html/home.htm
	install -m 644 ${WORKDIR}/upgrade.htm ${S}/home/httpd/html/Management/upgrade.htm
	sed -i -e s/@ds_sw_version#/@ds_sw_version#-uNSLUng-${DISTRO_VERSION}/ \
		${S}/home/httpd/html/Management/upgrade.htm

	install -m 755 ${WORKDIR}/ipkg-fl ${S}/usr/bin/ipkg-fl
	install -m 644 ${WORKDIR}/motd-fl ${S}/etc/motd-fl
	sed -i -e s/@v@/V2.3R63-uNSLUng-${DISTRO_VERSION}/ ${S}/etc/motd-fl
	install -m 644 ${WORKDIR}/motd-un ${S}/etc/motd-un
	sed -i -e s/@v@/V2.3R63-uNSLUng-${DISTRO_VERSION}/ ${S}/etc/motd-un
	rm -f ${S}/etc/motd
	ln -s motd-fl ${S}/etc/motd
	sed -i -e 's+@public_2#</td>+@public_2# <span class="divider"> | </span><a href="Management/telnet.cgi" class="submenu">\&nbsp; Manage Telnet</a></td>+' \
		${S}/home/httpd/html/home.htm
	sed -i -e 's+<td bgcolor="#6666cc" align="right" height="33" valign="middle">&nbsp;  </td>+<td bgcolor="#6666cc" fgcolor="#ffffff" align="right" height="33" valign="middle"><center><span class=mainmenu>uNSLUng status: \&nbsp; Running from Internal Flash</span></center></td>+' \
		${S}/home/httpd/html/home.htm

	sed -i -e 's|>&nbsp;<|><a href="Unslung" class="mainmenu" target="_top">Unslung Doco</a><|' \
		${S}/home/httpd/html/manhead.htm
	install -d ${S}/opt/doc
	install -m 755 ${WORKDIR}/README ${S}/opt/doc/README
	install -m 755 ${WORKDIR}/NOTES ${S}/opt/doc/NOTES
	rm -f ${S}/home/httpd/html/Unslung
	ln -s /opt/doc ${S}/home/httpd/html/Unslung

	install -m 755 ${WORKDIR}/linuxrc ${S}/linuxrc

	# Allow rc.bootbin to be diverted.
	mv ${S}/etc/rc.d/rc.bootbin ${S}/sbin/rc.bootbin
	install -m 755 ${WORKDIR}/rc.bootbin ${S}/etc/rc.d/rc.bootbin

	install -d ${S}/initrd

	install -m 755 ${WORKDIR}/unsling ${S}/sbin/unsling
	install -m 755 ${WORKDIR}/resling ${S}/sbin/resling
	install -m 755 ${WORKDIR}/slingover ${S}/sbin/slingover
	install -m 755 ${WORKDIR}/rc.optware-start ${S}/etc/rc.d/rc.optware-start
	install -m 755 ${WORKDIR}/rc.optware-stop ${S}/etc/rc.d/rc.optware-stop

	install -m 644 ${WORKDIR}/nsswitch.conf ${S}/etc/nsswitch.conf

	# Add the diversion script directory
	install -d ${S}/unslung

	# Remove the libraries, because they are in nslu2-linksys-libs now
	rm -rf ${S}/lib

	# Remove some unnecessary web stuff to free space
	rm -f ${S}/home/httpd/html/Management/upgrade.cgi
	rm -f ${S}/home/httpd/html/Management/upgrade_ui.htm
	rm -f ${S}/home/httpd/html/Management/upgrade_ui.cgi

	# Remove some of the Samba codepages to make space
	# These will have to be separately packaged, like the libraries...
	# 437 (USA) - keep
	# 737 (Greek)
	rm -f ${S}/etc/samba/codepages/codepage.737
	rm -f ${S}/etc/samba/codepages/unicode_map.737
	# 850 (Latin1) - keep
	# 852 (Latin2)
	rm -f ${S}/etc/samba/codepages/codepage.852
	rm -f ${S}/etc/samba/codepages/unicode_map.852
	# 861 (Iceland)
	rm -f ${S}/etc/samba/codepages/codepage.861
	rm -f ${S}/etc/samba/codepages/unicode_map.861
	# 866 (Russian)
	rm -f ${S}/etc/samba/codepages/codepage.866
	rm -f ${S}/etc/samba/codepages/unicode_map.866
	# 932 (Japanese Shift-JIS)
	rm -f ${S}/etc/samba/codepages/codepage.932
	rm -f ${S}/etc/samba/codepages/unicode_map.932
	# 936 (Simplified Chinese)
	rm -f ${S}/etc/samba/codepages/codepage.936
	# 949 (Korean)
	rm -f ${S}/etc/samba/codepages/codepage.949
	# 950 (Chinese BIG-5)
	rm -f ${S}/etc/samba/codepages/codepage.950
	# ISO8859-1 (Latin 1) - keep

	# /bin/killall and /usr/bin/killall are both symlinks to busybox.  This
	# is a problem if killall is ever replaced by slingbox or a native utility.
	# Fix by making /bin/killall (the wrong place) a symlink to /usr/bin/killall.
	rm -f ${S}/bin/killall
	ln -s ../usr/bin/killall ${S}/bin/killall

	# There are two identical binary copies of "date" on the image.  Replace
	# the one in /usr/sbin with a symlink to the one in /bin.  This saves a
	# bit of flash space, and makes it possible to replace the date binary with
	# a link to busybox or slingbox at some point.
	rm -r ${S}/usr/sbin/date
	ln -s ../../bin/date ${S}/usr/sbin/date
}

do_install () {
	( cd ${S} ; tar -c -v -f - --exclude '.pc' . ) | ( cd ${D} ; tar xvf - )
}

PACKAGES = "${PN}"
FILES_${PN} = "/"
RDEPENDS_${PN} = "nslu2-linksys-libs"
