# stress .bb build file
# Copyright (C) 2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see /COPYING)

HOMEPAGE="http://weather.ou.edu/~apw/projects/stress/"
DESCRIPTION = "a simple tool that imposes certain types of compute stress on UNIX-like operating systems."
MAINTAINER = "Raymond Danks <info-linux@geode.amd.com>"
LICENSE = "GPL"

inherit autotools

SRC_URI="http://weather.ou.edu/~apw/projects/stress/stress-${PV}.tar.gz"
