#! /bin/sh
#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2007
# License: MIT (see http://www.opensource.org/licenses/mit-license.php 
#               for a copy of the license)
#
# Filename: hentges-x11-image.bb
# Date: 20070522 (YMD)

DESCRIPTION = "Hentges X11 Image"
HOMEPAGE = "http://www.hentges.net/misc/openzaurus/index.shtml"
LICENSE = "MIT"

######################################################################################

PV = "${HENTGES_PV}"
PR = "${HENTGES_PR}"

######################################################################################

export IMAGE_NAME = "hentges-x11-image"
export IMAGE_LINGUAS = ""
export PACKAGE_INSTALL = "${RDEPENDS}"

######################################################################################

PREFERRED_PROVIDER_libgpewidget 	?= "libgpewidget"
PREFERRED_PROVIDER_tslib 		?= "tslib"
PREFERRED_PROVIDER_virtual/libsdl 	?= "libsdl-x11"
PREFERRED_PROVIDER_virtual/libxine 	?= "libxine-x11"
PREFERRED_PROVIDER_virtual/libx11       ?= "diet-x11"

######################################################################################

DEPENDS = "task-base \
	   task-hentges-base \
	   task-hentges-x11"

RDEPENDS = "task-base \
	    task-hentges-base \
	    task-hentges-x11"

######################################################################################

inherit image


