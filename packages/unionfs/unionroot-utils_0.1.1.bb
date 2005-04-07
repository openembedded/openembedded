LICENSE = "GPL"

DESCRIPTION = "Tools for administering a system that utilises unionroot."
DEPENDS = "ipkg-collateral unionroot busybox"
RDEPENDS = "ipkg-collateral unionroot busybox"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Chris Lord <cwiiis@handhelds.org>"

PR = "2"

SRC_URI = "file://mount.unionroot \
	   file://umount.unionroot"

do_install () {
	install -d ${D}${base_bindir}
	install -m 0755 ${WORKDIR}/mount.unionroot ${D}${base_bindir}/
	install -m 0755 ${WORKDIR}/umount.unionroot ${D}${base_bindir}/
}

pkg_postinst () {
	update-alternatives --install /bin/mount mount /bin/mount.unionroot 100
	update-alternatives --install /bin/umount umount /bin/umount.unionroot 100

	# Alter /etc/ipkg.conf
	mv $D/${sysconfdir}/ipkg.conf $D/${sysconfdir}/ipkg.conf.old
        awk 'BEGIN { print "# Altered by unionroot" }
                   { if ( $3 == "/" )
                     {
                        print $1 " " $2 " /media/realroot"
                     }
                     else
                     {
                        print $0
                     }
                   }' $D/${sysconfdir}/ipkg.conf.old > $D/${sysconfdir}/ipkg.conf
}

pkg_prerm () {
	update-alternatives --remove mount /bin/mount.unionroot
	update-alternatives --remove umount /bin/umount.unionroot
}

