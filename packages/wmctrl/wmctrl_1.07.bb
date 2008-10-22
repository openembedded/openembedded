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
