require changedfiles.inc
PR = "r1"

SRC_URI += "file://autofoo.patch;patch=1"

inherit autotools

do_compile() {
	oe_runmake daemon
}

do_install() {
	oe_runmake -C daemon install bindir=${D}${bindir} sysconfdir=${D}${sysconfdir}
}

SRC_URI[md5sum] = "e44e2a833151632dae7b68e815400bc1"
SRC_URI[sha256sum] = "26991b827f96a49ebd164409852d781b0a74a765c385c56c21a7ae44d030ab42"
