require intltool_${PV}.bb

inherit native

export PERL = "/usr/bin/env perl"
SRC_URI_append = " file://intltool-nowarn.patch;patch=1"

SRC_URI[md5sum] = "95c4bd2a91419083ee880a3f53f86edf"
SRC_URI[sha256sum] = "4ebece4bb752e22b2f15a9fe24e83aec59a3a41b67a9fa9ffd6b805c519e90ba"
