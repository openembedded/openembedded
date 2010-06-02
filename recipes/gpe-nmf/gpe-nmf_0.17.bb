require gpe-nmf.inc

RDEPENDS_${PN} = ""
RRECOMMENDS_${PN} = ""

SRC_URI += "file://fix_makefiles.patch"

SRC_URI[md5sum] = "3fd22f7d95f9e1f328d768dedf7313a5"
SRC_URI[sha256sum] = "6c11e7af568bf13602dec79cba5aacea590a2ec585f96dc96f87fa8950ffc31d"
