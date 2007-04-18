#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2006
# License: MIT (see COPYING.MIT)
#
# Filename: essential-image.bb
# Date: 23-Apr-06

DESCRIPTION = "<description>"
HOMEPAGE = "http://www.hentges.net/misc/openzaurus/index.shtml"

######################################################################################

PV = "0.0.1"
PR = "r0"

######################################################################################

inherit image

######################################################################################

DEPENDS = "task-essential-to-boot"

######################################################################################

export IMAGE_BASENAME = "essential-image"
export IMAGE_LINGUAS = ""
export PACKAGE_INSTALL = "task-essential-to-boot"
