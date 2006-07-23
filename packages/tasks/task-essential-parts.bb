#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2006
# License: GPL (see http://www.gnu.org/licenses/gpl.txt for a copy of the license)
#
# Filename: task-essential-parts.bb
# Date: 23-Apr-06

DESCRIPTION = "Creates all task-essential-* tasks"
MAINTAINER = "Matthias 'CoreDump' Hentges <oe@hentges.net>"
HOMEPAGE = "http://www.hentges.net/misc/openzaurus/index.shtml"

######################################################################################

PV = "0.0.1"
PR = "r1"

######################################################################################

PACKAGE_ARCH = "${MACHINE}"
ALLOW_EMPTY = 1

PACKAGES = "task-essential-irda task-essential-bluetooth task-essential-bluetooth-all \
	    task-essential-sound task-essential-sd task-essential-wifi task-essential-wifi-all \
	    task-essential-usbclient task-essential-usbhost task-essential-pcmcia \
	    task-essential-userspace task-essential-serial"

######################################################################################

DISTRO_PCMCIA ?= ""

DISTRO_SERIAL ?= ""
DISTRO_IRDA ?= ""
DISTRO_BLUETOOTH ?= ""
DISTRO_SOUND ?= ""
DISTRO_WIFI ?= "hostap-utils prism3-firmware prism3-support spectrum-fw hostap-conf orinoco-conf \
		wireless-tools wpa-supplicant-nossl"

DISTRO_USBCLIENT ?= ""
DISTRO_USBHOST ?= ""

DISTRO_SD ?= ""

DISTRO_USERSPACE ?= "ipkg keymaps"

DISTRO_DEPENDS ?= "hostap-utils prism3-firmware prism3-support spectrum-fw hostap-conf orinoco-conf \
		   ipkg keymaps altboot wireless-tools wpa-supplicant-nossl"

######################################################################################

RDEPENDS_task-essential-serial = "${KMODULES_SERIAL} ${MACHINE_MODUTILS} ${MACHINE_SERIAL} ${DISTRO_SERIAL}"
RDEPENDS_task-essential-irda = "task-essential-serial ${KMODULES_IRDA} ${MACHINE_MODUTILS} ${MACHINE_IRDA} ${DISTRO_IRDA}"
RDEPENDS_task-essential-bluetooth = "${KMODULES_BLUETOOTH} ${MACHINE_MODUTILS} ${MACHINE_HOTPLUG} ${MACHINE_BLUETOOTH} "
RDEPENDS_task-essential-bluetooth-all = "task-essential-bluetooth ${KMODULES_BLUETOOTH_DRIVER} ${DISTRO_BLUETOOTH}"
RDEPENDS_task-essential-pcmcia = "${KMODULES_PCMCIA} ${MACHINE_MODUTILS} ${MACHINE_HOTPLUG} ${MACHINE_PCMCIA} ${DISTRO_PCMCIA}"
RDEPENDS_task-essential-sound = "${KMODULES_SOUND} ${MACHINE_MODUTILS} ${MACHINE_SOUND} ${DISTRO_SOUND}"
RDEPENDS_task-essential-sd = "${KMODULES_SD} ${MACHINE_MODUTILS} ${MACHINE_HOTPLUG} ${MACHINE_SD} ${DISTRO_SD}"
RDEPENDS_task-essential-wifi = "${KMODULES_WIFI} ${MACHINE_MODUTILS} ${MACHINE_HOTPLUG} ${MACHINE_WIFI}"
RDEPENDS_task-essential-wifi-all = "task-essential-wifi ${KMODULES_WIFI_DRIVER} ${DISTRO_WIFI}"
RDEPENDS_task-essential-usbclient = "${KMODULES_USBCLIENT} ${MACHINE_MODUTILS} ${MACHINE_HOTPLUG} ${MACHINE_USBCLIENT} ${DISTRO_USBCLIENT}"
RDEPENDS_task-essential-usbhost = "${KMODULES_USBHOST} ${MACHINE_MODUTILS} ${MACHINE_HOTPLUG} ${MACHINE_USBHOST} ${DISTRO_USBHOST}"
RDEPENDS_task-essential-userspace = "${DISTRO_USERSPACE}"


DEPENDS = "${MACHINE_DEPENDS} ${DISTRO_DEPENDS}"
