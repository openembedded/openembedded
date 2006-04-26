#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2006
# License: GPL (see http://www.gnu.org/licenses/gpl.txt for a copy of the license)
#
# Filename: task-essential-to-boot.bb
# Date: 23-Apr-06

DESCRIPTION = "This task includes everything to make a bootable image. And not a bit more."
MAINTAINER = "Matthias 'CoreDump' Hentges <oe@hentges.net>"
HOMEPAGE = "http://www.hentges.net/misc/openzaurus/index.shtml"

######################################################################################

ALLOW_EMPTY = 1
PACKAGES = "${PN}"

######################################################################################

PV = "0.0.1"
PR = "r0"

######################################################################################

CORE_EXTRA_D ?= ""
CORE_EXTRA_RD ?= ""

CORE_PACKAGES_D = "virtual/kernel base-files base-passwd-3.5.9 busybox initscripts \
		   sysvinit tinylogin ${CORE_EXTRA_D}"

CORE_PACKAGES_RD = "kernel base-files base-passwd busybox initscripts sysvinit \
		    tinylogin ${CORE_EXTRA_RD}"

######################################################################################		    
		    
DEPENDS = "${CORE_PACKAGES_D}"
RDEPENDS = "${CORE_PACKAGES_RD}"
