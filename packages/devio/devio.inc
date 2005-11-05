# This package builds the devio program
DESCRIPTION = "devio - block devio io"
HOMEPAGE = "http://devio.sourceforge.net/"
MAINTAINER = "John Bowler <jbowler@acm.org>"
SECTION = "base"
LICENSE = "MIT"

SRC_URI = "${SOURCEFORGE_MIRROR}/devio/devio-${PV}.tar.gz"

# Source directory
S = "${WORKDIR}/devio-${PV}"

# Just the one package at present
PACKAGES = "${PN}"

# Set the install dir to /sbin, not /usr/sbin, because devio is used
# during bootstrap (we want it to be posible to mount /usr separately)
sbindir = "/sbin"

inherit autotools
