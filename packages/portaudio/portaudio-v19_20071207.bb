#! /bin/sh
#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2008
# License: MIT (see http://www.opensource.org/licenses/mit-license.php 
#               for a copy of the license)
#
# Filename: portaudio-v19_20071207.bb
# Date: 20080104 (YMD)

DESCRIPTION = "portaudio is a portable cross-platform Audio API"
SECTION = "base"
LICENSE = "GPL"

PR = "r0"

######################################################################################

SRC_URI = "http://www.portaudio.com/archives/pa_stable_v19_${PV}.tar.gz"

S = "${WORKDIR}/portaudio"

inherit autotools

do_stage() {
        install -m 0644 ${S}/include/portaudio.h ${STAGING_INCDIR}/
        oe_libinstall -C lib -so libportaudio ${STAGING_LIBDIR}/
}
