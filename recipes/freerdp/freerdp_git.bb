# Copyright (C) 2010, O.S. Systems Software Ltda. All Rights Reserved
# Released under the MIT license

include freerdp.inc

PR = "${INC_PR}.2"
PV = "0.8.1-${PR}+gitr${SRCREV}"
S = "${WORKDIR}/git"

SRCREV = "210fa972d96ecf927b75ca983b4551858a091ae7"

SRC_URI = "git://freerdp.git.sourceforge.net/gitroot/freerdp/freerdp.git;protocol=git"
