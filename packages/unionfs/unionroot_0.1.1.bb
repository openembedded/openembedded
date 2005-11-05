LICENSE = "GPL"

DESCRIPTION = "Provides an init script that changes the root file-system to unionfs."
DEPENDS = "busybox base-files"
RDEPENDS = "busybox base-files"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Chris Lord <cwiiis@handhelds.org>"

SRC_URI = "file://init.unionroot"

inherit update-alternatives

ALTERNATIVE_NAME = "init"
ALTERNATIVE_LINK = "/sbin/init"
ALTERNATIVE_PATH = "/sbin/init.unionroot"
ALTERNATIVE_PRIORITY = "100"

do_install () {
        install -d ${D}${base_sbindir}
        install -m 0755 ${WORKDIR}/init.unionroot ${D}${base_sbindir}/
}

pkg_postinst () {
	# Alter /etc/fstab
	mv $D/${sysconfdir}/fstab $D/${sysconfdir}/fstab.old
	awk 'BEGIN { print "# Altered by unionroot" }
		   { if ( $2 == "/" )
		     {
		     	print $1 "\t/media/realroot\t" $3 "\t" $4 "\t" $5 "\t" $6
		     }
		     else
		     {
		     	print $0
		     }
		   }' $D/${sysconfdir}/fstab.old > $D/${sysconfdir}/fstab
}

