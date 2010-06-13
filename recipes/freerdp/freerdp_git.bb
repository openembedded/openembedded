# Copyright (C) 2010, O.S. Systems Software Ltda. All Rights Reserved
# Released under the MIT license

include freerdp.inc

PR = "${INC_PR}.1"
PV = "0.7.0+gitr${SRCPV}"
S = "${WORKDIR}/git"

SRCREV = "fe0c56a36522ff8f64f1ad111efe4cfd572e2e53"
SRC_URI = "git://freerdp.git.sourceforge.net/gitroot/freerdp/freerdp.git;protocol=git"
