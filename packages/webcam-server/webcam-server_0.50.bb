#! /bin/sh
#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2007
# License: MIT (see http://www.opensource.org/licenses/mit-license.php 
#               for a copy of the license)
#
# Filename: Untitled
# Date: 20070317 (YMD)

DESCRIPTION = "webcam_server is a program that allows others to view your webcam from a web browser."
HOMEPAGE = "http://webcamserver.sourceforge.net/"
LICENSE = "GPL"

PR = "r1"

######################################################################################

DEPENDS = "jpeg"

SRC_URI = "${SOURCEFORGE_MIRROR}/webcamserver/webcam_server-${PV}.tar.gz"

S = "${WORKDIR}/webcam_server-${PV}"

######################################################################################

inherit autotools
