# micro-image
#
# Image configuration for the OE Micro Linux Distribuion (micro, micro-uclibc)
#
# This image basically consists of: libc, busybox, udev, sysv init, and a few
# init scripts for running up the system.
#
# It is truely tiny and should build with most architectures/machines.
#
# The image is tested to build and run succesfully with the following machines:
#
#	* at91sam9263ek (jffs2 image size ~ 1 MB, uclibc)
#	* x86
#
# Maintainer: Martin Lund <mgl@doredevelopment.dk>
#

# Install basic files only
IMAGE_INSTALL = "base-files base-passwd"
IMAGE_LINGUAS = ""

# Use busybox as login manager
IMAGE_LOGIN_MANAGER = "busybox"

# Include minimum init and init scripts
IMAGE_DEV_MANAGER = "udev"
IMAGE_INIT_MANAGER = "sysvinit sysvinit-pidof"
IMAGE_INITSCRIPTS = ""

inherit image
