#! /bin/sh
#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2007
# License: MIT (see http://www.opensource.org/licenses/mit-license.php 
#               for a copy of the license)
#
# Filename: task-hentges-x11.bb
# Date: 20070522 (YMD)

DESCRIPTION = "task-hentges-x11"
HOMEPAGE = "http://www.hentges.net/misc/openzaurus/index.shtml"
LICENSE = "MIT"

######################################################################################

ALLOW_EMPTY = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

######################################################################################

PV = "${HENTGES_PV}"
PR = "${HENTGES_PR}"

######################################################################################
	    
DEPENDS = "task-angstrom-x11"

RDEPENDS = "${HENTGES_X11_RDEPENDS}"
