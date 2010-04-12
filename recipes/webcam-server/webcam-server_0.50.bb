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

SRC_URI[md5sum] = "96830836f64edbb12c248eb84e6b0d18"
SRC_URI[sha256sum] = "b8e200ae66c20897c9aaa80b0044e638a0016d3bdb6e67560fd61f1ef162f305"
