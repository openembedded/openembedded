#! /bin/sh
#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2007
# License: MIT (see http://www.opensource.org/licenses/mit-license.php 
#               for a copy of the license)
#
# Filename: hentges-console-image.bb
# Date: 20070516 (YMD)

DESCRIPTION = "Hentges Console Image"
HOMEPAGE = "http://www.hentges.net/misc/openzaurus/index.shtml"
LICENSE = "GPL"

######################################################################################

PV = "${HENTGES_PV}"
PR = "${HENTGES_PR}"

######################################################################################

export IMAGE_NAME = "hentges-console-image"
export IMAGE_LINGUAS = ""
export PACKAGE_INSTALL = "${RDEPENDS}"

######################################################################################

DEPENDS = "task-base \
	   task-hentges-base"

RDEPENDS = "task-base \
	    task-hentges-base"

######################################################################################

inherit image


