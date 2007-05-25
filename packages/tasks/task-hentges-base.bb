#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2007
# License: MIT (see http://www.opensource.org/licenses/mit-license.php 
#               for a copy of the license)
#
# Filename: task-hentges-base.bb
# Date: 20070516 (YMD)

DESCRIPTION = "task-hentges-base"
MAINTAINER = "Matthias 'CoreDump' Hentges <oe@hentges.net>"
HOMEPAGE = "http://www.hentges.net/misc/openzaurus/index.shtml"
LICENSE = "MIT"

######################################################################################

ALLOW_EMPTY = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

######################################################################################

PV = "${HENTGES_PV}"
PR = "${HENTGES_PR}"

######################################################################################
	    
#DEPENDS = "${HENTGES_DEPENDS}"
#
RDEPENDS = "${HENTGES_BASE_RDEPENDS}"
