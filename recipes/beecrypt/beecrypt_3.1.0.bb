# Beecrypt OE build file
# Copyright (C) 2004-2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="Beecrypt is a general-purpose cryptography library."
HOMEPAGE="http://sourceforge.net/projects/beecrypt"
SRC_URI="${SOURCEFORGE_MIRROR}/beecrypt/beecrypt-${PV}.tar.gz \
         file://x64fix.patch;patch=1"

PR = "r4"

inherit autotools
acpaths=""

EXTRA_OECONF="--with-arch=${TARGET_ARCH} --enable-shared --enable-static"

do_stage() {
    autotools_stage_all
}


SRC_URI[md5sum] = "1472cada46e2ab9f532f984de9740386"
SRC_URI[sha256sum] = "50b574d330fecbc9faed81746a1abfcec903c264ae753ac64d4edf22c701519f"
