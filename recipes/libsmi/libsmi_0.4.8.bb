DESCRIPTION = "A Library to Access SMI MIB Information"
LICENSE = "BSD"
SRC_URI = "ftp://ftp.ibr.cs.tu-bs.de/pub/local/libsmi/libsmi-0.4.8.tar.gz"
PR = "r1"

inherit autotools

PACKAGES += "${PN}-mibs ${PN}-pibs"
FILES_${PN}-mibs += "${datadir}/mibs"
FILES_${PN}-pibs += "${datadir}/pibs"

do_stage() {
      autotools_stage_all
}


SRC_URI[md5sum] = "760b6b1070738158708649ed2c63425e"
SRC_URI[sha256sum] = "f048a5270f41bc88b0c3b0a8fe70ca4d716a46b531a0ecaaa87c462f49d74849"
