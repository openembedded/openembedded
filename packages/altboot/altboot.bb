DESCRIPTION = "A text-based bootmanager allowing a Zaurus to boot from SD, CF, USB-Storage and NFS. \
Tested machines: Collie, Poodle, Akita, Spitz"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Matthias 'CoreDump' Hentges  <oe@hentges.net>"
LICENSE = "GPL"
IGNORE_STRIP_ERRORS = "1"

PR = "r16"


SRC_URI = "file://altboot-menu \
	   file://altboot.rc \
	   file://altboot.func \	 
	   file://init.altboot \
	   file://altboot*.cfg"

# S = "${WORKDIR}/files"
 
do_install() {
	install -d ${D}/sbin
	install -d ${D}/etc/altboot-menu
	install -d ${D}/etc/altboot-menu/Advanced
	install -d ${D}/etc/altboot.rc
	install -d ${D}/usr/share/doc/altboot
	
	install -m 0644 ${WORKDIR}/altboot*.cfg ${D}/etc
	install -m 0644 ${WORKDIR}/altboot.func ${D}/etc
#	install -m 0644 ${WORKDIR}/docs/altboot/*.txt ${D}/usr/share/doc/altboot
	install -m 0755 ${WORKDIR}/init.altboot ${D}/sbin	
	install -m 0755 ${WORKDIR}/altboot-menu/*-* ${D}/etc/altboot-menu
	install -m 0755 ${WORKDIR}/altboot-menu/Advanced/*-* ${D}/etc/altboot-menu/Advanced
	install -m 0755 ${WORKDIR}/altboot.rc/*.sh ${D}/etc/altboot.rc
	install -m 0644 ${WORKDIR}/altboot.rc/*.txt ${D}/etc/altboot.rc	
}		



pkg_postinst() {
	update-alternatives --install /sbin/init init /sbin/init.altboot 55
}

pkg_postinst_spitz() {
	# Note: Spitz support is a royal pain in the ass.
	#       Since Spitz pivot_roots by default, there is no real way
	#	a user can install an altboot.ipk into the flash FS.
	#	So we need to do that manually (*SIGH*)

	# /l/m only exists on the HDD on spitz
	if test -d /lib/modules
	then
	   if [ -e /media/realroot/sbin/init ]; then
	      ROOT_MOUNT_POINT="/media/realroot"
	   elif [ -e /media/ROM/sbin/init ]; then
	      ROOT_MOUNT_POINT="/media/ROM"
	   fi
	   if [ ! "$ROOT_MOUNT_POINT" = "" ]; then
	      ROOT_MOUNT_DEVICE=`cat /proc/mounts | grep $ROOT_MOUNT_POINT | grep jffs2 | cut -d " " -f 1`
	      if [ ! "$ROOT_MOUNT_DEVICE" = "" ]; then
	         mount -oremount,rw $ROOT_MOUNT_DEVICE $ROOT_MOUNT_POINT
	         cp -R /etc/altboot* $ROOT_MOUNT_POINT/etc
	         cp /sbin/init.altboot $ROOT_MOUNT_POINT/sbin
	         if [ -f $ROOT_MOUNT_POINT/sbin/init ]; then
	         	 mv $ROOT_MOUNT_POINT/sbin/init $ROOT_MOUNT_POINT/sbin/init.orig
	         fi
	         ln -s /sbin/init.altboot $ROOT_MOUNT_POINT/sbin/init
	      fi
	   fi
	fi
}

pkg_postrm() {
	update-alternatives --remove init /sbin/init.altboot
}

pkg_postrm_spitz() {
	if test -d /lib/modules
        then
           if [ -e /media/realroot/sbin/init ]; then
              ROOT_MOUNT_POINT="/media/realroot"
           elif [ -e /media/ROM/sbin/init ]; then
              ROOT_MOUNT_POINT="/media/ROM"
           fi
           if [ ! "$ROOT_MOUNT_POINT" = "" ]; then
              ROOT_MOUNT_DEVICE=`cat /proc/mounts | grep $ROOT_MOUNT_POINT | grep jffs2 | cut -d " " -f 1`
              if [ ! "$ROOT_MOUNT_DEVICE" = "" ]; then
                 mount -oremount,rw $ROOT_MOUNT_DEVICE $ROOT_MOUNT_POINT
	         if [ -f $ROOT_MOUNT_POINT/sbin/init.orig ]; then
	            rm $ROOT_MOUNT_POINT/sbin/init
	            rm $ROOT_MOUNT_POINT/sbin/init.altboot
	            mv $ROOT_MOUNT_POINT/sbin/init.orig $ROOT_MOUNT_POINT/sbin/init
	         else
	   	 echo "$ROOT_MOUNT_POINT/sbin/init.orig not found, not uninstalling altboot!"
	         fi
	      fi
           fi
	fi
}
