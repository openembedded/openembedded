# stress .bb build file
# Copyright (C) 2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see /COPYING)

HOMEPAGE="http://weather.ou.edu/~apw/projects/stress/"
DESCRIPTION = "a simple tool that imposes certain types of compute stress on UNIX-like operating systems."
LICENSE = "GPL"

inherit autotools

SRC_URI="http://weather.ou.edu/~apw/projects/stress/stress-${PV}.tar.gz"

SRC_URI[md5sum] = "d693ff044ac7d34f8aaea202cd96f679"
SRC_URI[sha256sum] = "778126fdcc3ecb54d4a8dad6164001603bcc3b79ba64b3c2c5285275bc0cbedf"
