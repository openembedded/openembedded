#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2006
# License: MIT (see COPYING.MIT)
#
# Filename: essential-image.bb
# Date: 23-Apr-06

HOMEPAGE = "http://www.hentges.net/misc/openzaurus/index.shtml"

DEPENDS = "task-essential-to-boot"
IMAGE_LINGUAS = ""
IMAGE_INSTALL = "task-essential-to-boot"

inherit image

