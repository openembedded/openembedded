#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2006
# License: GPL (see http://www.gnu.org/licenses/gpl.txt for a copy of the license)
#
# Filename: essential-machine-image.bb
# Date: 24-Apr-06

DESCRIPTION = "<description>"
MAINTAINER = "Matthias 'CoreDump' Hentges <oe@hentges.net>"
HOMEPAGE = "http://www.hentges.net/misc/openzaurus/index.shtml"

######################################################################################

PV = "0.0.1"
PR = "r0"

######################################################################################

inherit image_ipk

######################################################################################

DEPENDS = "task-essential-to-boot task-essential-parts"

######################################################################################

MACHINE_TASKS_akita = "task-essential-to-boot \
		       task-essential-pcmcia task-essential-userspace \
		       task-essential-usbhost task-essential-usbclient \
		       task-essential-sound task-essential-irda \
		       task-essential-sd"
		       
######################################################################################

export IMAGE_BASENAME = "essential-image"
export IMAGE_LINGUAS = ""
export IPKG_INSTALL = "${MACHINE_TASKS}"
