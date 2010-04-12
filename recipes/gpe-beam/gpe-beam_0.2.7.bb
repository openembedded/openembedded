require ${PN}.inc

RDEPENDS = "libopenobex-1.0-1 irda-utils"
PR = "r1"

SRC_URI += "file://decl.patch;patch=1;pnum=0"

inherit gpe

SRC_URI[md5sum] = "d68b45964816a6a3d98d1501bc520b6f"
SRC_URI[sha256sum] = "386dd48c7bce7900291c27deef3a68fd00257f6072a1644517ce49a4b0cb1936"
