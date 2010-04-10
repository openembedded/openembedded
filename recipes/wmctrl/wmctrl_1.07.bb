#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2006
# License: MIT (see http://www.opensource.org/licenses/mit-license.php for a copy of the license)
#
# Filename: wmctrl_1.07.bb
# Date: 07-Jul-06

DESCRIPTION = "A UNIX/Linux command line tool to interact with an EWMH/NetWM compatible X Window Manager"
HOMEPAGE = "http://sweb.cz/tripie/utils/wmctrl/"
LICENSE = "GPL"
PR = "r0"

######################################################################################

SRC_URI = "http://sweb.cz/tripie/utils/wmctrl/dist/wmctrl-1.07.tar.gz"

######################################################################################

inherit autotools

SRC_URI[md5sum] = "1fe3c7a2caa6071e071ba34f587e1555"
SRC_URI[sha256sum] = "d78a1efdb62f18674298ad039c5cbdb1edb6e8e149bb3a8e3a01a4750aa3cca9"
