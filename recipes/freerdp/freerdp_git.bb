# Copyright (C) 2010, O.S. Systems Software Ltda. All Rights Reserved
# Released under the MIT license

include freerdp.inc

inherit gitpkgv

PV = "gitr${SRCPV}"
PKGV = "${GITPKGVTAG}"

SRCREV = "aec5dd5807dbcd0989bb15124dcac157bb0412bc"
PR = "${INC_PR}.4"

S = "${WORKDIR}/git"


SRC_URI = "git://freerdp.git.sourceforge.net/gitroot/freerdp/freerdp.git;protocol=git"
