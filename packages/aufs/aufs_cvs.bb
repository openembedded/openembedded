DESCRIPTION = "Aufs is a stackable unification filesystem such as Unionfs, which unifies several directories and provides a merged single directory."
HOMEPAGE = "http://aufs.sourceforge.net/"
LICENSE = "GPL"
PV = "cvs${SRCDATE}"
PR = "r1"

RSUGGESTS_${PN} = "${PN}-tools"

inherit module

S = "${WORKDIR}/aufs"

# We do not create the manpage for aufs because we do not install it anyway.
# If you want to have the manpage created you will need to add host cc to
# the makefile else it will fail to crosscompile.
# See http://svn.exactcode.de/t2/trunk/package/filesystem/aufs/compile.patch.cross
# as an example how this could be done.

SRC_URI = "cvs://anonymous@aufs.cvs.sourceforge.net/cvsroot/aufs;module=aufs;date=${SRCDATE} \
	file://aufs_create_no_manpage.patch;patch=1 "

EXTRA_OEMAKE = "KDIR=${STAGING_KERNEL_DIR} -f local.mk"

# We need to check the architecture and the kernel version to
# configure properly lokal.mk. We ignore the export CONFIG_AUFS_STAT option.
# If you want to have CONFIG_AUFS_STAT enabled you have to add some other ARCH checks.
# Debian does not enable CONFIG_AUFS_STAT for arm.
# We disable CONFIG_AUFS_SYSAUFS for arm because arm does not know about cmpxchg.
# If you want this feature enabled you have to define it.
# I suggest you to read http://osdir.com/ml/linux.kernel.tracing/2006-12/msg00020.html

do_configure() {
	K_VERSION=$(echo ${KERNEL_VERSION} | awk 'BEGIN{FS="."}{print $3}')
	cd ${S}
	if [ $K_VERSION -ge 24 ] ; then	
		sed -i 's/CONFIG_AUFS_FAKE_DM\ =\ y/CONFIG_AUFS_FAKE_DM\ =/g'  local.mk
	fi
	if [ $K_VERSION -eq 25 ] || [ $ARCH = "arm" ] ; then
		sed -i 's/CONFIG_AUFS_SYSAUFS\ =\ y/CONFIG_AUFS_SYSAUFS\ =/g'  local.mk 
	fi
}

do_install() {
	install -d ${D}/${sbindir}
	install -m 0500 mount.aufs umount.aufs auplink aulchown ${D}/${sbindir}
	install -d ${D}/etc/default	
	echo FLUSH=ALL > ${D}/etc/default/auplink
	install -d ${D}/${base_libdir}/modules/${KERNEL_VERSION}/drivers/extra/	
	install -m 0644 aufs.ko ${D}/${base_libdir}/modules/${KERNEL_VERSION}/drivers/extra/
}


FILES_${PN} = "/lib/modules"
PACKAGES += "${PN}-tools"
FILES_${PN}-tools = "${sbindir} /etc/default/auplink"
