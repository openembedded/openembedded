# This package builds the devio program
PR = "r0"
DESCRIPTION = "devio - block devio io"
HOMEPAGE = "http://devio.sourceforge.net/"
MAINTAINER = "John Bowler <jbowler@acm.org>"
SECTION = "base"
LICENSE = "MIT"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/devio;method=pserver;module=devio;tag=${PV}"
# This accesses the head version, anonymous pserver access is
# only updated once per day (and it is necessary to change
# 'jbowler' to the name of a developer with ssh access.)
#SRC_URI = "cvs://jbowler@cvs.sourceforge.net/cvsroot/devio;method=ext;rsh=ssh;tag=HEAD;module=devio"

# The source will end up in the subdirectory 'devio' - no release name
S = "${WORKDIR}/devio"

# Just the one package at present
PACKAGES = "${PN}"

# Set the install dir to /sbin, not /usr/sbin, because devio is used
# during bootstrap (we want it to be posible to mount /usr separately)
sbindir = "/sbin"

inherit autotools
