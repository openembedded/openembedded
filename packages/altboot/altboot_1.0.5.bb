#! /bin/sh
#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2006
# License: GPL (see http://www.gnu.org/licenses/gpl.txt for a copy of the license)
#
# Filename: altboot_1.0.5-rc2.bb
# Date: 21-Feb-06

DESCRIPTION = "The altboot bootmanager"
HOMEPAGE = "http://www.hentges.net/misc/openzaurus/index.shtml"
LICENSE = "GPL"

######################################################################################

PR = "r0"

######################################################################################

PACKAGE_ARCH = "${MACHINE}"

TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '-')}"

SRC_URI = "svn://hentges.net/altboot/tags/;module=${TAG};rev=4"

S = "${WORKDIR}/${TAG}/"

######################################################################################

do_install() {
	install -d ${D}/sbin
	install -d ${D}/etc/altboot-menu
	install -d ${D}/etc/altboot-menu/Advanced
	install -d ${D}/etc/altboot.rc
	install -d ${D}/usr/share/doc/altboot

	if test -d ${WORKDIR}/altboot/${MACHINE}
	then
		install -m 0644 ${S}/${MACHINE}/altboot*.cfg ${D}/etc
	else
		install -m 0644 ${S}/altboot*.cfg ${D}/etc
	fi

	install -m 0644 ${S}/altboot.func ${D}/etc
	install -m 0755 ${S}/init.altboot ${D}/sbin

	if test -d ${S}/${MACHINE}/altboot-menu/
	then
		install -m 0755 ${S}/${MACHINE}/altboot-menu/*-* ${D}/etc/altboot-menu
	else
		install -m 0755 ${S}/altboot-menu/*-* ${D}/etc/altboot-menu
	fi

	if test -d ${S}/${MACHINE}/altboot-menu/Advanced/
	then
		install -m 0755 ${S}/${MACHINE}/altboot-menu/Advanced/*-* ${D}/etc/altboot-menu/Advanced
	else
		install -m 0755 ${S}/altboot-menu/Advanced/*-* ${D}/etc/altboot-menu/Advanced
	fi

	install -m 0755 ${S}/altboot.rc/*.sh ${D}/etc/altboot.rc
	install -m 0644 ${S}/altboot.rc/*.txt ${D}/etc/altboot.rc
}

######################################################################################

do_configure() {
	cat ${S}/init.altboot | sed "s/^VERSION=.*/VERSION=\"${PV}\"/" > ${S}/init.altboot_
	mv ${S}/init.altboot_ ${S}/init.altboot
}

######################################################################################

pkg_postinst() {
	update-alternatives --install /sbin/init init /sbin/init.altboot 55
}

pkg_postinst_spitz() {
	# Note: Spitz support is a royal pain in the ass.
	#       Since Spitz pivot_roots by default, there is no real way
	#	a user can install an altboot.ipk into the flash FS.
	#	So we need to do that manually (*SIGH*)

    # the 2.6 kernel for spitz boots from HDD, no need to copy to flash
    if cat /proc/version | awk '{print $3}' | grep -q '^2.6'; then
        update-alternatives --install /sbin/init init /sbin/init.altboot 55
    # no need to copy to flash if we're installing to flash already
    elif mount | grep ' / ' | grep -q mtdblock; then
        update-alternatives --install /sbin/init init /sbin/init.altboot 55
    else
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
    fi
}

######################################################################################

pkg_postrm() {
	update-alternatives --remove init /sbin/init.altboot
}

pkg_postrm_spitz() {
    # the 2.6 kernel for spitz boots from HDD, no need to remove from flash
    if cat /proc/version | awk '{print $3}' | grep -q '^2.6'; then
        update-alternatives --remove init /sbin/init.altboot
    # no need to copy to flash if we're removing from flash already
    elif mount | grep ' / ' | grep -q mtdblock; then
        update-alternatives --remove init /sbin/init.altboot
    else
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
    fi
}




